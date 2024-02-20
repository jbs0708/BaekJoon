col, row = map(int, input().split())
N = int(input())
r_list = [0]
c_list = [0]

for n in range(N):
    rc, n = map(int, input().split())
    if rc:
        c_list.append(n)
    else:
        r_list.append(n)

r_list.append(row)
c_list.append(col)

r_list.sort()
# print(f'r_list: {r_list}')
c_list.sort()
# print(f'c_list: {c_list}')

c_max, r_max = 0, 0

if c_list:
    for c in range(1, len(c_list)):
        c_max = max(c_max, c_list[c] - c_list[c-1])

if r_list:
    for r in range(1, len(r_list)):
        r_max = max(r_max, r_list[r] - r_list[r-1])

# print(r_max, c_max)
print(r_max * c_max)