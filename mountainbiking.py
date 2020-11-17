import math

[N, g] = [x for x in input().strip().split(" ")]

N = int(N)
g = float(g)

data = [[float(x) for x in input().strip().split(" ")] for _ in range(N)]

for i in range(N, 0, -1):
    u = 0.0
    for j in range(N - i, N):
        [D, theta] = data[j]
        a = g * math.cos(math.radians(theta))

        v = math.sqrt(abs(u ** 2 + 2 * a * D))

        u = v

    print(u)
