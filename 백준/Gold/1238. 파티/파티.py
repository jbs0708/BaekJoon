import heapq
import sys

input = sys.stdin.readline

def dijk(start):
    q = []
    distance = [float('inf')] * (N + 1)

    heapq.heappush(q, (start, 0))
    distance[start] = 0

    while q:
        loc, dis = heapq.heappop(q)

        if distance[loc] < dis:
            continue

        for idx, cost in graph[loc]:
            temp = dis + cost

            if distance[idx] > temp:
                distance[idx] = temp
                heapq.heappush(q, (idx, temp))

    return distance


N, M, X = map(int, input().rstrip().split())
graph = [[] for _ in range(N + 1)]

for i in range(M):
    s, e, d = map(int, input().rstrip().split())
    graph[s].append([e, d])

ans = 0
back = dijk(X)
for i in range(1, N+1):
    if i != X:
        go = dijk(i)
        ans = max(ans, go[X] + back[i])

print(ans)

