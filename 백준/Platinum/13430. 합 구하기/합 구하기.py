k, n = map(int, input().split())

ans = 1

for i in range(k+1):
    ans *= (n+i)
    ans //= (i+1)

ans %= 1000000007

print(ans)