input()
arr = [int(x) for x in input().strip().split(" ")]


def decode(x):
    prev = x & 1 == 1

    res = x & 1

    for i in range(1, 8):
        x = x >> 1
        curr = x & 1 == 1

        newBit = False

        # prev xor (bit to find) = curr
        # 1 xor 0 = 1
        # 0 xor 1 = 1
        # 0 xor 0 = 0
        # 1 xor 1 = 0

        if curr:
            newBit = not prev
        else:
            newBit = prev

        # res = res << 1
        res = res | newBit << i
        prev = newBit

    return res


print(" ".join(map(lambda x: str(decode(x)), arr)))
