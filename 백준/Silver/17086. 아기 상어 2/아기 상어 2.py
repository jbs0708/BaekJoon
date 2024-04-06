from collections import deque

xi = [0, 0, 1, -1, -1, 1, -1, 1]
yi = [1, -1, 0, 0, -1, -1, 1, 1]


N, M = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(N)]
dp = [[float('inf')] * M for _ in range(N)]
sharks = []

for i in range(N):
    for j in range(M):
        if matrix[i][j] == 1:
            sharks.append([i, j])
            dp[i][j] = 0

for shark in sharks:
    i, j = shark
    q = deque()
    q. append([i, j, 1])
    while q:
        y, x, cnt = q.popleft()

        for d in range(8):
            dx = x + xi[d]
            dy = y + yi[d]

            if 0 <= dx < M and 0 <= dy < N and cnt < dp[dy][dx]:
                dp[dy][dx] = cnt
                q.append([dy, dx, cnt+1])

min_ = max(map(max, dp))

print(min_)