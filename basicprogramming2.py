def intr(): return [int(x) for x in input().strip().split(" ")]


def one():
    arr.sort()

    i = 0
    j = len(arr) - 1

    while i < j:
        left = arr[i]
        right = arr[j]

        sm = left + right

        if sm > 7777:
            j -= 1
        elif sm < 7777:
            i += 1
        else:
            if left != right:
                print("Yes")
            else:
                print("No")
            return

    print("No")


def two():
    found = {}

    for n in arr:
        if n in found:
            print("Contains duplicate")
            return
        else:
            found[n] = True

    print("Unique")


def three():
    found = {}

    n = len(arr)

    for num in arr:
        if num in found:
            found[num] = found[num] + 1
        else:
            found[num] = 1

        if found[num] > n / 2:
            print(num)
            return

    print("-1")


def four():
    ln = len(arr)
    arr.sort()

    if ln % 2 == 0:
        print("{} {}".format(arr[ln//2 - 1], arr[ln//2]))
    else:
        print(arr[ln//2])


def five():
    arr.sort()

    res = filter(lambda a: a >= 100 and a <= 999, arr)

    print(" ".join(map(str, res)))


[_, t] = intr()
arr = intr()

if t == 1:
    one()
elif t == 2:
    two()
elif t == 3:
    three()
    pass
elif t == 4:
    four()
elif t == 5:
    five()
