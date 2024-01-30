import math

NS = list(map(int, input().split()))
N = NS[0]
S = NS[1]

n_list = list(map(int, input().split()))

n_list.append(S)
n_list.sort()
ans = 0

if N == 1:
    ans = n_list[1] - n_list[0]
else:
    ans = n_list[1] - n_list[0]
    for n in range(N):
        ans = math.gcd(n_list[n+1] - n_list[n], ans)

print(ans)
