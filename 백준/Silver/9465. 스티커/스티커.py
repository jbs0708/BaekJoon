T = int(input())
for tc in range(T):
    N = int(input())
    inp = [list(map(int, input().split())) for i in range(2)]

    if N == 1:
        print(max(inp[0][0], inp[1][0]))
        continue

    dp = [[0] * N for _ in range(2)]

    dp[0][0] = inp[0][0]
    dp[1][0] = inp[1][0]

    if N > 1:
        dp[0][1] = inp[1][0] + inp[0][1]
        dp[1][1] = inp[0][0] + inp[1][1]

    for i in range(2, N):
        dp[0][i] = max(dp[1][i - 1], dp[1][i - 2]) + inp[0][i]
        dp[1][i] = max(dp[0][i - 1], dp[0][i - 2]) + inp[1][i]

    print(max(dp[0][N - 1], dp[1][N - 1]))