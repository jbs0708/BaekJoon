
R, C, N = map(int, input().split())
matrix = [list(input()) for _ in range(R)]


if N % 2 == 0:
    for i in range(R):
        for j in range(C):
            print('O', end='')
        print()
else:

    if N == 1:
        for i in range(R):
            for j in range(C):
                print(matrix[i][j], end='')
            print()
    else:
        xi = [0, 0, 1, -1]
        yi = [1, -1, 0, 0]
        time = N//2
        booms = []
        for i in range(R):
            for j in range(C):
                if matrix[i][j] == 'O':
                    booms.append([i, j])

        new3_matrix = [['O'] * C for _ in range(R)]

        for boom in booms:
            y, x = boom
            new3_matrix[y][x] = '.'

            for i in range(4):
                dx = x + xi[i]
                dy = y + yi[i]

                if 0 <= dx < C and 0 <= dy < R and new3_matrix[dy][dx] == 'O':
                    new3_matrix[dy][dx] = '.'

        booms = []
        for i in range(R):
            for j in range(C):
                if new3_matrix[i][j] == 'O':
                    booms.append([i, j])

        new5_matrix = [['O']*C for _ in range(R)]

        for boom in booms:
            y, x = boom
            new5_matrix[y][x] = '.'

            for i in range(4):
                dx = x + xi[i]
                dy = y + yi[i]

                if 0 <= dx < C and 0 <= dy < R and new5_matrix[dy][dx] == 'O':
                    new5_matrix[dy][dx] = '.'

        if time % 2 == 0:
            for i in range(R):
                for j in range(C):
                    print(new5_matrix[i][j], end='')
                print()
        else:
            for i in range(R):
                for j in range(C):
                    print(new3_matrix[i][j], end='')
                print()




