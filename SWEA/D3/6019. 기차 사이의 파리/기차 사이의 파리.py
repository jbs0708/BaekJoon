T = int(input())

for tc in range(1, T + 1):
    DABF = list(map(int, input().split()))

    D = DABF[0]
    A = DABF[1]
    B = DABF[2]
    F = DABF[3]

    ans = 0
    time = D / (A+B)
    ans += F * time

    print(f'#{tc} {ans}')