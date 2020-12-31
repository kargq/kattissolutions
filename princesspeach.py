[n, y] = map(int, input().strip().split(" "))

mario = [int(input()) for _ in range(y)]

for i in range(n):
    if i not in mario:
        print(i)

print("Mario got {} of the dangerous obstacles.".format(len([x for x in range(n) if x in mario])))
