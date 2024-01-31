def boom(x, y, ran):
    global list_
    global M
    global N

    cnt = -list_[x][y]
    for dx in range(x-ran, x+ran+1):
        if dx < 0 or dx >= N:
            continue
        cnt += list_[dx][y]
    for dy in range(y-ran, y+ran+1):
        if dy < 0 or dy >= M:
            continue
        cnt += list_[x][dy]

    return cnt


T = int(input())

for tc in range(1, T+1):
    NM = list(map(int, input().split()))
    N, M = NM[0], NM[1]

    list_ = [list(map(int, input().split())) for _ in range(N)]
    max_ = 0

    for i in range(N):
        for j in range(M):
            max_ = max(boom(i, j, list_[i][j]), max_)

    print(f'#{tc} {max_}')