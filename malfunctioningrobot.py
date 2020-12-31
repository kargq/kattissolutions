cases = int(input())

for _ in range(cases):
    [x1, y1, x2, y2] = [int(x) for x in input().strip().split(" ")]

    xdiff = abs(x2 - x1)
    ydiff = abs(y2 - y1)

    if abs(ydiff - xdiff) <= 1:
        print(xdiff + ydiff)
    else:
        mx = max(xdiff, ydiff)
        mn = min(xdiff, ydiff)

        if mn % 2 == 0:
            if mx % 2 == 0:
                # both even
                print(mx * 2)
            else:
                print(mx * 2 - 1)
        else:
            if mx % 2 == 0:
                # odd even
                print(mx * 2 - 1)
            else:
                print(mx * 2)
