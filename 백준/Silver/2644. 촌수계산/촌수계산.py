
def search(cnt, idx, visited):
    global ans

    if idx == E:
        ans = cnt
        return

    for i in graph[idx]:
        if not visited[i]:
            visited[i] = 1
            search(cnt+1, i, visited)
            visited[i] = 0


N = int(input())
S, E = map(int, input().split())
M = int(input())
ans = -1
visited = [0] * (N+1)

graph = [[] for _ in range(N+1)]
for m in range(M):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

search(0, S, visited)

print(ans)

