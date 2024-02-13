T = 10

for tc in range(1, T + 1):
    N = int(input())
    input_list = input()
    stack = ''
    ans = ''
    sum_ = 0

    for i in range(N):
        if input_list[i].isnumeric():
            ans += input_list[i]
            sum_ += int(input_list[i])
        else:
            stack += input_list[i]

    print(f'#{tc} {sum_}')
    # print(ans + stack)