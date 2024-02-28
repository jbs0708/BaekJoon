def func(start, cnt):
    global ans

    if cnt == 0:
        sum_ = ''
        for s in str_list:
            sum_ += s

        ans = max(ans, int(sum_))
        return

    for i in range(start, len(str_input)-1):
        for j in range(i+1, len(str_input)):
            str_list[i], str_list[j] = str_list[j], str_list[i]
            func(i, cnt-1)
            str_list[i], str_list[j] = str_list[j], str_list[i]


T = int(input())

for tc in range(1, T+1):
    str_input, N = input().split()
    N = int(N)

    # 변경 횟수 줄이기
    if len(str_input) < N and N % 2 == 0:
        N = len(str_input)

    str_list = list(str_input)
    ans = 0
    func(0, N)
    print(f'#{tc} {ans}')