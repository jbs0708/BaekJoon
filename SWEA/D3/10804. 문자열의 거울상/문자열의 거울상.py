T = int(input())

for tc in range(1, T+1):
    str_list = list(input())

    dict = {'p' : 'q', 'b' : 'd', 'd' : 'b', 'q' : 'p'}

    ans = ''
    for s in str_list:
        ans += dict[s]

    ans = ans[::-1]

    print(f'#{tc} {ans}')