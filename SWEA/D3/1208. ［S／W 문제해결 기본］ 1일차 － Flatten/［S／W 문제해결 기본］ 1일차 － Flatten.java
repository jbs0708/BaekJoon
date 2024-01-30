T = 10

for tc in range(1, T+1):
    N = int(input())
    dump_list = list(map(int, input().split()))
    for n in range(N):
        dump_list.sort()
        if dump_list[0] == dump_list[len(dump_list)-1]:
            break
        else:
            dump_list[0] += 1
            dump_list[len(dump_list)-1] -= 1

    ans = max(dump_list) - min(dump_list)

    print(f'#{tc} {ans}')