T = int(input())

for tc in range(1, T+1):
    A, B = map(str, input().split())


    ans = 0
    a = 0
    while a < len(A):
        cnt = 0
        if A[a:a+len(B)] == B:
            ans += 1
            a += len(B)
        else:
            ans += 1
            a += 1

    print(f'#{tc} {ans}')