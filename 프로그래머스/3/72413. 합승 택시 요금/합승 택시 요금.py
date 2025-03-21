def shortest(dis, visited, size):
    minVal = float("inf")
    idx = 0
    for i in range(1, size+1):
        if dis[i] < minVal and not visited[i]:
            minVal = dis[i]
            idx = i
    return idx


def dijkstra(start,size,graph):
    visited = [0] * (size+1)
    distance = [float("inf")] * (size+1)
    distance[start] = 0
    visited[start] = 1
    for i in graph[start]:
        distance[i[0]] = i[1]
    
    for i in range(size-1):
        curr = shortest(distance, visited, size)
        visited[curr] = 1
        
        for j in graph[curr]:
            cost = distance[curr] + j[1]
            distance[j[0]] = min(cost, distance[j[0]])
    
    return distance
        
    


def solution(n, s, a, b, fares):
    answer = float("inf")
    graph = [[] for _ in range(n+1)]
    for c,d,f in fares:
#       양방향
        graph[c].append([d,f])
        graph[d].append([c,f])
        
    abDijk = dijkstra(s,n,graph)
    aDijk = dijkstra(a,n,graph)
    bDijk = dijkstra(b,n,graph)
    
    for i in range(n+1):
        answer = min(answer,abDijk[i]+aDijk[i]+bDijk[i])
    
    return answer