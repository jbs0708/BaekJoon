N = int(input())
matrix = [list(map(int, input().split())) for _ in range(N)]


dp = [[[0 for _ in range(N)] for _ in range(N)] for _ in range(3)]

dp[0][0][1] = 1

for i in range(2, N):
    if matrix[0][i] == 0:
        dp[0][0][i] = dp[0][0][i-1]

for i in range(1, N):
    for j in range(1, N):
        if matrix[i][j] == 0 and matrix[i][j - 1] == 0 and matrix[i-1][j] == 0:
            dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1]

        if matrix[i][j] == 0:
            dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1]
            dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j]


print(sum(dp[i][N-1][N-1] for i in range(3)))