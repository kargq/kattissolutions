import sys
import math
import functools
import operator

for line in sys.stdin:
    word = line.strip()

    keyMap = {}

    for c in word:
        if c in keyMap:
            keyMap[c] = keyMap[c] + 1
        else:
            keyMap[c] = 1

    num = math.factorial(len(word))
    den = functools.reduce(
        operator.mul, [math.factorial(v) for v in keyMap.values()], 1)

    print(num // den)
