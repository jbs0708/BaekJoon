n, m, k = map(int, input().split())
position = list(map(int, input().split()))

# 심판 사이의 최소 거리 : 1
start = 1
# 최대거리 (끝점 - 첫점)
end = position[-1] - position[0]

# 이진탐색
while start <= end:
    mid = (start + end) // 2
    cnt = 1
    prev = position[0]
    for i in range(1, k):
        if position[i] - prev >= mid:
            cnt += 1
            prev = position[i]
    
    # 배치가 끝났는데 배정해야될 심판이 남은 경우
    if cnt < m:
        # 거리를 줄여서 여유공간을 더 만들고 재배치
        end = mid - 1
    else:
        # 공간이 남은 경우, 거리 늘리기
        result = mid
        start = mid + 1

ans = '1'
cnt = 1
prev = position[0]
for i in range(1, k):
    # 전,후 거리가 최소거리보다 크면 ans 심판 누적 숫자가 전체인원보다 작을 때
    if position[i] - prev >= result and cnt < m:
        ans += '1'
        cnt += 1
        prev = position[i]
    else:
        ans += '0'

print(ans)