import math


def inr():
    return [int(x) for x in input().strip().split(" ")]


def flt():
    return [float(x) for x in input().strip().split(" ")]


[n, m, k] = inr()


def sq_rad(side):
    return side * math.sqrt(2) / 2

# def sfits(side, plot):
#     diag = side * math.sqrt(2)
#     return diag <= plot * 2


def cfits(rad, plot):
    return rad < plot


plots = sorted(flt())

chouses = flt()

rhouses = flt()
rchouses = [sq_rad(side) for side in rhouses]

# print(rhouses)
# print(rchouses)

allh = sorted(chouses + rchouses, reverse=True)


count = 0

for plot_r in plots:
    for index, house_r in enumerate(allh):
        if house_r < plot_r:
            count += 1
            allh.pop(index)
            # print("yes fit", plot_r, house_r)
            break


print(count)
