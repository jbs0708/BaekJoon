import copy
from collections import deque
from itertools import combinations


xi = [0, 1, 0, -1]
yi = [1, 0, -1, 0]


def diffusion(mat):
    global safety_area

    q = deque()
    for v in viruses:
        q.append(v)

    cnt = 3
    while q:
        y, x = q.popleft()

        for i in range(4):
            dx = x + xi[i]
            dy = y + yi[i]
            if 0 <= dx < M and 0 <= dy < N and mat[dy][dx] == 0:
                mat[dy][dx] = 2
                q.append([dy, dx])
                cnt = cnt+1

    temp = zero_area - cnt
    safety_area = max(safety_area, temp)


N, M = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(N)]

viruses = []
empty = []

for i in range(N):
    for j in range(M):
        if matrix[i][j] == 2:
            viruses.append([i, j])
        elif matrix[i][j] == 0:
            empty.append([i, j])

zero_area = len(empty)
safety_area = 0

for walls in combinations(empty, 3):
    for wall in walls:
        y, x = wall
        matrix[y][x] = 1
    mat = copy.deepcopy(matrix)
    diffusion(mat)
    for wall in walls:
        y, x = wall
        matrix[y][x] = 0

print(safety_area)


