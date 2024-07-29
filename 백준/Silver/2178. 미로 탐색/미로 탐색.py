from queue import PriorityQueue

N, M = map(int, input().split())

map = [list(map(int, input())) for i in range(N)]
visit = [[float('inf') for _ in range(M)] for _ in range(N)]
visit[0][0] = 1

pq = PriorityQueue()

xi = [0, 0, 1, -1]
yi = [1, -1, 0, 0]

pq.put([1, 0, 0])

while pq:
    temp, y, x = pq.get()
    if y == N-1 and x == M-1:
        print(temp)
        break

    for i in range(4):
        ny = yi[i] + y
        nx = xi[i] + x

        if ny >= 0 and nx >= 0 and ny < N and nx < M:
            if temp+1 < visit[ny][nx] and map[ny][nx] == 1:
                visit[ny][nx] = temp+1
                pq.put([temp+1, ny, nx])