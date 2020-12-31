cases = int(input())


def ip():
    return [int(x) for x in input().strip().split(" ")]


for _ in range(cases):
    input()
    [ng, nm] = ip()

    ngs = ip()
    ngd = {}
    ngmx = 0

    for x in ngs:
        ngmx = max(ngmx, x)
        if x in ngd:
            ngd[x] = ngd[x] + 1
        else:
            ngd[x] = 1

    nms = ip()
    nmd = {}
    nmmx = 0

    for y in nms:
        nmmx = max(nmmx, y)
        if y in nmd:
            nmd[y] = nmd[y] + 1
        else:
            nmd[y] = 1

    mx1 = ngd[ngmx]
    mx2 = nmd[nmmx]

    if ngmx < nmmx:
        print("MechaGodzilla")
    elif ngmx > nmmx:
        print("Godzilla")
    else:
        if mx1 < mx2:
            print("MechaGodzilla")
        elif mx1 > mx2:
            print("Godzilla")
        else:
            print("Godzilla")
