import math


# def incomplete_gamma(p, x):
#     return 4 * x / h(p, x)


# def h(p, x):
#     return 3 * (x ** 2 - p) + math.sqrt((x ** 2 - p) ** 2 + 8 * (x ** 2 + p))


# def vol(a, b, h):
#     return math.pi * (0.25) * (
#         math.sqrt(2 * math.pi) * (a ** 2) * math.erf(math.sqrt(2) * h) -
#         (4 * a * b * math.pow(h ** 2, 1/4) * incomplete_gamma(3/4, h ** 2)) / math.sqrt(h) +
#         2 * (b ** 2) * (h ** 2)
#     )

# def vol(a, b, h):
#     return (0.5) * math.pow(math.pi, 3/2) * a * math.erf(h) + (b ** 2) * (h ** 2) / 2

# print(vol(1,2, 2))


# N = 2
# V = 25
# h = 2

# graduations = 200

# height = h / graduations

# for i in range()

# print()
def f(a, b, x):
    return a * math.pow(math.e, -x ** 2) + b * math.sqrt(x)


def vol(a, b, h):
    grads = 1000000
    height = h / grads

    res = 0

    for i in range(grads):
        x = i * height
        r =  f(a, b, x)
        res += height * math.pi * r ** 2

    return res


[V, N] = [x for x in input().strip().split(" ")]

V = float(V)
N = int(N)

for i in range(N):
    [a, b, h] = [float(x) for x in input().strip().split(" ")]

    print(vol(a, b, h))
