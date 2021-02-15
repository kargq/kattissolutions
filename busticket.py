[s, p, m, n] = [int(x) for x in input().strip().split(" ")]
ts = [int(x) for x in input().strip().split(" ")]
# t1 t2 t3 ... tn
prices = [0] * n

for i in range(n):
    start = i

    while start >= 0 and ts[i] - ts[start] < m:
        start -= 1

    start += 1

    wo = None

    if i > 0:
        wo = prices[i - 1] + s
    else:
        wo = s

    wth = wo

    if start > 0:
        wth = prices[start - 1] + p
    else:
        wth = p

    prices[i] = min(wo, wth)

print(prices[-1])
