import math

[s, v1, v2] = [int(x) for x in input().strip().split(" ")]

m = - v1 / v2
c = s / v2
x_end = -c / m
mx = None
my = None

def ya(x):
    return (s - v1 * x) / v2

for x in range(math.floor(x_end) + 1):
    y = ya(x)
    if y == math.floor(y):
        if (not mx) or (mx + my > x + y):
            mx = int(x)
            my = int(y)

if mx != None:
    print(mx, my)
else:
    print("Impossible")
