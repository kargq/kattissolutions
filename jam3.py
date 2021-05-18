# Google codejam 2021 Qualification, problem 3

from itertools import permutations


def is_sorted(l):
    for i in range(0, len(l) - 1):
        if l[i] > l[i + 1]:
            # print("not sorted", l)
            return False
    # print("sorted", l)
    return True


def revsort(l):
    res = 0
    for i in range(0, len(l) - 1):

        if is_sorted(l):
            # print(i, len(l))
            return res + (len(l) - 1) - i

        j = i
        for x in range(i, len(l)):
            if l[j] > l[x]:
                j = x

        rev = [z for z in reversed(l[i:j+1])]

        # print(i, j, (j - i + 1))
        res += (j - i + 1)

        count = 0
        for ind in range(i, j + 1):
            l[ind] = rev[count]
            count += 1

    return res


t = int(input())


for i in range(1, t + 1):
    # _ = input()
    # l = [int(x) for x in input().strip().split(" ")]
    [n, c] = [int(x) for x in input().strip().split(" ")]
    res = "IMPOSSIBLE"

    mx = (n + 1) * (n - 1) - (n - 1) * (n) / 2
    # print(mx)

    if c >= n - 1 and c <= mx:
        nums = [i for i in range(1, n + 1)]

        for tup in permutations(nums):
            l = [x for x in tup]
            # print(l)
            r = revsort(l)
            # print(r, c)
            if r == c:
                res = " ".join(map(str, tup))
                break

    print("Case #{}: {}".format(i, res))
