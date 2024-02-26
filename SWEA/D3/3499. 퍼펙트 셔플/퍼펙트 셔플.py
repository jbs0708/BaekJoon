
from collections import deque

T = int(input())

for tc in range(1, T+1):
    N = int(input())
    cards = list(input().split())
    shuffled = deque()

    if N % 2 == 1:
        card_1 = cards[:N//2 + 1]
        card_2 = cards[N//2 + 1:]
        for i in range(N):
            if i % 2 == 0:
                shuffled.append(card_1[i//2])
            else:
                shuffled.append(card_2[i//2])
    else:
        card_1 = cards[:N//2]
        card_2 = cards[N//2:]
        for i in range(N):
            if i % 2 == 0:
                shuffled.append(card_1[i//2])
            else:
                shuffled.append(card_2[i//2])

    print(f'#{tc} ', end='')
    for q in shuffled:
        print(q, end=' ')
    print()
