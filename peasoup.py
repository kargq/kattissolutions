n = int(input())

for _ in range(n):
    pea = False
    pan = False
    items = int(input())
    name = input().strip()
    for _ in range(items):
        item = input().strip()
        if item == "pea soup":
            pea = True

        if item == "pancakes":
            pan = True

        if pea and pan:
            print(name)
            exit()

print("Anywhere is fine I guess")
