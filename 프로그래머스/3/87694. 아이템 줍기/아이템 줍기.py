from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    posVisit = [[-1] * 102 for _ in range(102)]
    
    for rect in rectangle:
        x1 = rect[0] * 2
        x2 = rect[2] * 2
        y1 = rect[1] * 2
        y2 = rect[3] * 2
        for i in range(x1, x2+1):
            for j in range(y1, y2+1):
                if x1 < i < x2 and y1 < j < y2:
                    posVisit[i][j] = 0
                elif posVisit[i][j] != 0:
                    posVisit[i][j] = 1
                    
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    
    q = deque()
    q.append([characterX * 2, characterY * 2])
    visit = [[-1] * 102 for _ in range(102)]
    visit[characterX * 2][characterY * 2] = 0
    
    while q:
        x, y = q.popleft()
        
        if x == itemX * 2 and y == itemY * 2:
            answer = visit[x][y] // 2
            break
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if posVisit[nx][ny] == 1 and visit[nx][ny] == -1:
                visit[nx][ny] = visit[x][y] + 1
                q.append([nx, ny])
    
    
    return answer