import sys

for line in sys.stdin:
    arr = line.strip().split(" ")
    bef = " ".join(arr[:3])

    d1 = arr[3].split(":")
    d2 = arr[4].split(":")

    n1 = int(d1[0]) * 60 + int(d1[1])
    n2 = int(d2[0]) * 60 + int(d2[1])

    diff = n2 - n1

    print("{} {} hours {} minutes".format(
        bef,
        diff // 60,
        diff - ((diff // 60) * 60)
    ))
