def selection_sort(a, N):
    for i in range(N-1):
        min_idx = i
        for j in range(i+1, N):
            if a[min_idx] > a[j]:
                min_idx = j
        a[min_idx], a[i] = a[i], a[min_idx]
    return


T = int(input())

for tc in range(1, T+1):
    N = int(input())
    n_list = list(map(int, input().split()))

    selection_sort(n_list, N)

    print(f'#{tc} ',end='')
    for n in n_list:
        print(f'{n} ',end='')
    print()