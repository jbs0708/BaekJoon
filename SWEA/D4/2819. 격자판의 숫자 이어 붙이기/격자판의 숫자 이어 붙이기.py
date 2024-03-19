xi = [0, 1, 0, -1]
yi = [1, 0, -1, 0]


def dfs(y, x, depth):
    global ans

    blank[depth] = list_[y][x]

    if depth == 6:
        temp = ''.join(blank)
        if temp not in ans:
            ans.append(temp)
        return


    for d in range(4):
        dx = xi[d] + x
        dy = yi[d] + y

        if 0 <= dx < 4 and 0 <= dy < 4:
            dfs(dy, dx, depth+1)
            blank[depth+1] = ''


T = int(input())

for tc in range(1, T+1):
    list_ = [list(input().split()) for _ in range(4)]
    # print(list_)
    ans = []
    blank = [''] * 7

    for i in range(4):
        for j in range(4):
            dfs(i, j, 0)

    print(f'#{tc} {len(ans)}')