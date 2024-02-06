T = int(input())

for tc in range(1, T+1):
    parenthesis_list = list(input())

    ans = 0
    cnt = 0
    p = 0
    while p < len(parenthesis_list):
        if parenthesis_list[p] == '(':
            cnt += 1
        elif parenthesis_list[p] == ')':
            if parenthesis_list[p-1] == '(':
                cnt -= 1
                ans += cnt
            else:
                cnt -= 1
                ans += 1

        p += 1

    print(f'#{tc} {ans}')