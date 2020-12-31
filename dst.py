cases = int(input())

day = 24 * 60

for _ in range(cases):
    [dr, d, h, m] = [x for x in input().strip().split(" ")]

    d = int(d)
    h = int(h)
    m = int(m)

    mintime = h * 60 + m

    if dr == "B":
        mintime = (mintime - d) % day
    if dr == "F":
        mintime = (mintime + d) % day

    hours = mintime // 60

    minutes = mintime - hours * 60

    print(hours, minutes)
