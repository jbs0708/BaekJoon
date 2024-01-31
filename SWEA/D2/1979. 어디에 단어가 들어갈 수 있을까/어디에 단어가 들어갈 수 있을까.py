T = int(input())

for tc in range(1, T+1):
    NK = list(map(int, input().split()))
    N, K = NK[0], NK[1]

    list_ = [list(map(int, input().split())) for _ in range(N)]

    ans = 0

    for i in range(N):
        cnt = 0
        max_ = 0
        for j in range(N):
            if list_[i][j] == 1:
                cnt += 1
                if max_ < cnt:
                    max_ = cnt
            else:
                if max_ == K:
                    ans += 1
                max_ = 0
                cnt = 0
        if max_ == K:
            ans += 1

    for i in range(N):
        cnt = 0
        max_ = 0
        for j in range(N):
            if list_[j][i] == 1:
                cnt += 1
                if max_ < cnt:
                    max_ = cnt
            else:
                if max_ == K:
                    ans += 1
                max_ = 0
                cnt = 0
        if max_ == K:
            ans += 1

    print(f'#{tc} {ans}')