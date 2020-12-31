from decimal import Decimal, ROUND_HALF_UP


def rd(x):
    return Decimal(x).quantize(0, ROUND_HALF_UP)


[c, k] = [int(x) for x in input().strip().split(" ")]

print(rd(c / 10 ** k) * 10 ** k)
