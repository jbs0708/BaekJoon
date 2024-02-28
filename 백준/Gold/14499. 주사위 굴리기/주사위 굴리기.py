xi = [1, -1, 0, 0]
yi = [0, 0, -1, 1]

def func(dy, dx):
    global cur_num

    if matrix[dy][dx] == 0:
        matrix[dy][dx] = dice[cur_num]
    else:
        dice[cur_num] = matrix[dy][dx]
        matrix[dy][dx] = 0

    return


T = 1

for tc in range(1, T+1):
    N, M, y, x, K = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(N)]

    # 동,서,북,남 => 1,2,3,4
    order = list(map(int, input().split()))
    # print(order)
    dice = [0, 0, 0, 0]
    # dice[0][3] = matrix[y][x]
    # dice[1][3] = matrix[y][x]
    cur_num = 3
    r = 0
    l = 0

    for ord in order:
        dx = x + xi[ord-1]
        dy = y + yi[ord-1]

        if 0 <= dx < M and 0 <= dy < N:
            x = dx
            y = dy
            # print(f'order: {ord}, point: {y,x}')

            if ord == 4:
                cur_num += 3
                cur_num %= 4

                if matrix[dy][dx] == 0:
                    matrix[dy][dx] = dice[cur_num]
                else:
                    dice[cur_num] = matrix[dy][dx]
                    matrix[dy][dx] = 0

            elif ord == 3:
                cur_num += 1
                cur_num %= 4

                if matrix[dy][dx] == 0:
                    matrix[dy][dx] = dice[cur_num]
                else:
                    dice[cur_num] = matrix[dy][dx]
                    matrix[dy][dx] = 0

            elif ord == 1:
                temp_l = dice[cur_num]
                temp_r = dice[(cur_num+2)%4]
                dice[cur_num] = r
                dice[(cur_num+2)%4] = l
                l = temp_l
                r = temp_r

                if matrix[dy][dx] == 0:
                    matrix[dy][dx] = dice[cur_num]
                else:
                    dice[cur_num] = matrix[dy][dx]
                    matrix[dy][dx] = 0

            elif ord == 2:
                temp_r = dice[cur_num]
                temp_l = dice[(cur_num+2)%4]
                dice[cur_num] = l
                dice[(cur_num+2)%4] = r
                r = temp_r
                l = temp_l

                if matrix[dy][dx] == 0:
                    matrix[dy][dx] = dice[cur_num]
                else:
                    dice[cur_num] = matrix[dy][dx]
                    matrix[dy][dx] = 0

            # print(l, dice, r)
            print(dice[(cur_num + 2) % 4])