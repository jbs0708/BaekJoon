T = int(input())

for tc in range(1, T+1):
    num = int(input())
    c = [0] * 12

    for i in range(6):
        c[num % 10] += 1
        num //= 10

    i = 0
    tri = run_ = 0
    while i < 10:
        if c[i] >= 3:
            c[i] -= 3
            tri += 1
            continue
        if c[i] > 0 and c[i+1] > 0 and c[i+2] > 0:
            c[i] -= 1
            c[i+1] -= 1
            c[i+2] -= 1
            run_ += 1
            continue
        i += 1

    print(f'#{tc} ',end='')
    if run_ + tri == 2:
        print('true')
    else:
        print('false')