n = int(input())

prev = input().strip()

used = {prev}

for i in range(1, n):
    curr = input().strip()

    if curr in used or prev[-1] != curr[0]:
        print("Player {} lost".format(i % 2 + 1))
        exit()

    prev = curr
    used.add(prev)

print("Fair game")
