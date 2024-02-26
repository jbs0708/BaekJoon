T = int(input())

for tc in range(1, T+1):
    N = int(input())
    ans = 0

    for i in range(N+1):
        for j in range(1, N+1):
            if i**2 + j**2 <= N**2:
                ans += 1

    ans *= 4
    ans += 1 

    print(f'#{tc} {ans}')