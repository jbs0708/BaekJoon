def roop():
    if len(temp) == M:
        for i in temp:
            print(i, end=" ")
        print()
    else:
        for i in arr:
            if i not in temp:
                temp.append(i)
                roop()
                temp.pop()


N, M = map(int, input().rstrip().split())
arr = list(map(int, input().split()))
arr.sort()
temp = []

roop()