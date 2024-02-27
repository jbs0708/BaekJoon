def oprimal_route(pos, cur_dis, cnt, route, dis_list):
    global ans
    x, y = pos

    if cnt == N+1:
        nx, ny = home
        dis = abs(nx - x) + abs(ny - y)


        if ans > cur_dis + dis:
            ans = cur_dis + dis
            # dis_list.append(dis)
            # print(f'cnt: {cnt}, ans: {ans}')
            # print(route)
            # print(dis_list)
            # dis_list.pop()
        return

    for i in range(1, N+1):
        if visited[i] == 0:
            visited[i] = 1
            nx, ny = customer[i]
            dis = abs(nx - x) + abs(ny - y)
            route.append(customer[i])
            dis_list.append(dis)
            oprimal_route(customer[i], cur_dis + dis, cnt + 1, route, dis_list)
            route.pop()
            dis_list.pop()
            visited[i] = 0


T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    min_ = float('inf')
    list_ = list(map(int, input().split()))
    company = (list_[0], list_[1])
    home = (list_[2], list_[3])
    customer = []
    ans = float('inf')
    visited = [0] * (N+1)
    visited[0] = 1

    route = [company]
    dis_list = []

    for i in range(4, 4+(N*2), 2):
        customer.append((list_[i], list_[i+1]))

    customer.insert(0, company)

    oprimal_route(company, 0, 1, route, dis_list)

    print(f'#{tc} {ans}')