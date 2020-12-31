ns = input().strip()
n = int(ns)


def har(num):
    by = sum(int(d) for d in str(num))
    return num % by == 0


if har(n):
    print(n)
else:
    i = n
    while True:
        i += 1
        if har(i):
            print(i)
            break
