import math


def rads(v):
    return math.sqrt(v / math.pi)


def check_in_drop(x, y, drop):
    (xc, yc, r, color) = drop

    return (xc - x) ** 2 + (yc - y) ** 2 < r ** 2


def check_color(x, y, drops):
    for drop in drops:
        if check_in_drop(x, y, drop):
            return drop[3]

    return "white"


c = int(input())


for i in range(c):
    n = int(input())
    drops = []
    for j in range(n):
        (x, y, v, color) = [o for o in input().strip().split(" ")]
        x = float(x)
        y = float(y)
        v = float(v)
        r = rads(v)

        drops.insert(0, (x, y, r, color))

    qs = int(input())
    for q in range(qs):
        [x, y] = [float(val) for val in input().strip().split(" ")]
        print(check_color(x, y, drops))
