arr = [int(x) for x in input().strip().split()]


def value(regs):
    return regs[0] + regs[1] * 2 + regs[2] * 2 * 3 + regs[3] * 2 * 3 * 5 + regs[4] * 2 * 3 * 5 * 7 + regs[5] * 2 * 3 * 5 * 7 * 11 + regs[6] * 2 * 3 * 5 * 7 * 11 * 13 + regs[7] * 2 * 3 * 5 * 7 * 11 * 13 * 17


print(value([1, 2, 4, 6, 10, 12, 16, 18]) - value(arr))
