import heapq

def dijkstra(graph, n):
    distance = [float("inf")] * (n+1)
    distance[0] = 0
    distance[1] = 0
    
    h = [(0, 1)]
    
    while h:
        curr_dis, curr_node = heapq.heappop(h)
        
        if curr_dis > distance[curr_node]:
            continue
        
        for nxt in graph[curr_node]:
            dis = curr_dis + 1
            if dis < distance[nxt]:
                distance[nxt] = dis
                heapq.heappush(h, (dis, nxt))
                
    return distance

def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n+1)]
    
    for v in edge:
        graph[v[0]].append(v[1])
        graph[v[1]].append(v[0])
        

    dijk = dijkstra(graph, n)
    
    answer = dijk.count(max(dijk))
    
    
    return answer