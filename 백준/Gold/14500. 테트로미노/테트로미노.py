def checkShapes(y, x, cnt, sum_, exception = -1):
    global max_

    cnt += 1

    if cnt > 4:
        max_ = max(max_, sum_)
        return
    sum_ += matrix[y][x]

    for i in range(4):
        if i != exception:
            dx = x + xi[i]
            dy = y + yi[i]

            if 0 <= dx < M and 0 <= dy < N:
                checkShapes(dy, dx, cnt, sum_, (i+2)%4)

def checkFuck(y, x):
    global max_
    for i in range(4):
        sum_ = matrix[y][x]
        for d in range(3):
            dx = x + xi[(i + d) % 4]
            dy = y + yi[(i + d) % 4]

            if 0 <= dx < M and 0 <= dy < N:
                sum_ += matrix[dy][dx]

        max_ = max(max_, sum_)



N, M = map(int, input().split())

matrix = [list(map(int, input().split())) for _ in range(N)]

xi = [1, 0, -1, 0]
yi = [0, 1, 0, -1]

max_ = 0
for y in range(N):
    for x in range(M):
        cnt = 0
        sum_s = 0
        checkShapes(y, x, cnt, sum_s)
        checkFuck(y, x)

print(max_)