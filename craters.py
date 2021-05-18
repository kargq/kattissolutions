# Solution does not work
import math
from functools import lru_cache
from itertools import combinations


def safe_atan(n, d):
    if d == 0:
        return math.pi / 2
    return math.atan(n / d)


def tangent(x1, y1, r1, x2, y2, r2):
    if r1 < r2:
        r1, r2 = r2, r1
        x1, x2 = x2, x1 
        y1, y2 = y2, y1

    D = distance(x1, y1, x2, y2)
    r3 = r1 - r2

    pass

    # gamma = - math.atan((y2 - y1) / (x2 - x1))
    # beta = math.asin((r2 - r1) / math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2))
    # alpha = gamma - beta

    # t1x1 = x1 + r1 * math.sin(alpha)
    # t1y1 = y1 + r1 * math.cos(alpha)
    # t1x2 = x2 + r2 * math.sin(alpha)
    # t1y2 = y2 + r2 * math.cos(alpha)

    # t2x1 = x1 - r1 * math.sin(alpha)
    # t2y1 = y1 - r1 * math.cos(alpha)
    # t2x2 = x2 - r2 * math.sin(alpha)
    # t2y2 = y2 - r2 * math.cos(alpha)

    # return (t1x1, t1y1, t1x2, t1y2, t2x1, t2y1, t2x2, t2y2)


n = int(input())


@lru_cache()
def line(x1, y1, x2, y2):
    return (x1, y1, x2, y2)


def get_side(line, x, y):
    (x1, y1, x2, y2) = line

    d = (x - x1) * (y2 - y1) - (y - y1) * (x2 - x1)
    if d < 0:
        return -1
    if d > 0:
        return 1
    else:
        return 0


def same_side(line, circles):
    side = None
    for [xc, yc, r] in circles:
        new_side = get_side(line, xc, yc)
        if new_side != 0 and side != None:
            if new_side != side:
                return False
        side = new_side
    return True


def as_string(tangent):
    (t_line, c1, c2) = tangent
    (x1, y1, x2, y2) = t_line
    (xc1, yc1, r1) = c1
    (xc2, yc2, r2) = c2
    return "({}, {}) and ({}, {})\n ({} - {})(y - {}) = ({} - {})(x - {})".format(xc1, yc1, xc2, yc2, x2, x1, y1, y2, y1, x1)


circles = [[float(x) for x in input().strip().split(" ")] for _ in range(n)]

tangents = []

# for (i, c1) in enumerate(circles):
#     for (j, c2) in enumerate(circles):
for (c1, c2) in combinations(circles, 2):
    [x1, y1, r1] = c1
    [x2, y2, r2] = c2
    (t1x1, t1y1, t1x2, t1y2, t2x1, t2y1, t2x2,
     t2y2) = tangent(x1, y1, r1, x2, y2, r2)
    line1 = line(t1x1, t1y1, t1x2, t1y2)
    line2 = line(t2x1, t2y1, t2x2, t2y2)

    tangents.append((line1, c1, c2))
    tangents.append((line2, c1, c2))

[print(as_string(t)) for t in tangents]


tangents = [x for x in tangents if same_side(x[0], circles)]


# print(len(tangents))
# [print(as_string(t)) for t in tangents]

# calculate the same tangents again but with increased radius by 10

final_tangents = []

for tangent_def in tangents:
    (t_line, c1, c2) = tangent_def
    # (x1, y1, x2, y2, m, c) = t_line
    (xc1, yc1, r1) = c1
    (xc2, yc2, r2) = c2

    r1 += 10
    r2 += 10

    (t1x1, t1y1, t1x2, t1y2, t2x1, t2y1, t2x2,
     t2y2) = tangent(xc1, yc1, r1, xc2, yc2, r2)
    line1 = line(t1x1, t1y1, t1x2, t1y2)
    line2 = line(t2x1, t2y1, t2x2, t2y2)

    final_tangents.append((line1, c1, c2))
    final_tangents.append((line2, c1, c2))

final_tangents = [x for x in final_tangents if same_side(x[0], circles)]

print(len(final_tangents))
[print(as_string(t)) for t in final_tangents]

# Find angles with center for final tangents

# def common_point(td1, td2):


def slope(x1, y1, x2, y2):
    return (y2 - y1) / (x2 - x1)


def angle(p1, p2, c):
    m1 = slope(*c, *p1)
    m2 = slope(*c, *p2)

    return abs(math.atan((m2 - m1) / (1 + m2 * m1)))


perimiter = 0


def distance(x1, y1, x2, y2):
    return math.sqrt((y2 - y1) ** 2 + (x2 - x1) ** 2)


for (tangent, _, _) in final_tangents:
    perimiter += distance(*tangent)

for (td1, td2) in combinations(final_tangents, 2):
    (t1, c11, c12) = td1
    (t2, c21, c22) = td2

    p1 = None
    p2 = None
    c = None
    if c11 == c21:
        p1 = t1[0], t1[1]
        p2 = t2[0], t2[1]
        c = c11
    elif c11 == c22:
        p1 = t1[0], t1[1]
        p2 = t2[2], t2[3]
        c = c11
    elif c12 == c21:
        p1 = t1[2], t1[3]
        p2 = t2[0], t2[1]
        c = c12
    elif c12 == c22:
        p1 = t1[2], t1[3]
        p2 = t2[2], t2[3]
        c = c12
    if p1 != None:
        # Horray, we found two points on the circle
        (xc, yc, r) = c
        theta = angle(p1, p2, (xc, yc))
        if theta < math.pi/2:
            theta = math.pi - theta
        print('theta', theta, c, p1, p2)
        perimiter += 2 * math.pi * r * theta / (2 * math.pi)

print(perimiter)
