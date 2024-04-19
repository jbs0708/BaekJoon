
KR_list = list(input())
rSum = KR_list.count('R')


s = 0
e = len(KR_list) - 1
ans = 0

sk, ek = 0, 0

while True:

    if s == e and KR_list[s] == 'R':
        temp = min(sk, ek)
        temp = (temp * 2) + rSum
        ans = max(temp, ans)
        break
    elif s >= e:
        break

    if KR_list[s] == KR_list[e] == 'R':
        temp = min(sk, ek)
        temp = (temp * 2) + rSum
        ans = max(temp, ans)

        if sk == ek:
            rSum = rSum - 2
            s = s+1
            e = e-1
        elif sk > ek:
            e = e-1
            rSum = rSum - 1
        else:
            s = s+1
            rSum = rSum - 1

        continue

    if KR_list[s] == 'K':
        s = s+1
        sk = sk + 1

    if KR_list[e] == 'K':
        e = e-1
        ek = ek + 1


print(ans)



