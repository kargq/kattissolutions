import sys


def things(crt):
    repIndex = len(crt[0]) - 1

    for ln in crt:
        line = ['.' for x in ln]
        ct = ln.count('*')

        while ct > 0:
            line[repIndex] = "*"
            ct -= 1
            repIndex -= 1

        print("".join(line))

skip = False

chrt = []

for line in sys.stdin:
    line = line.strip()
    if line == "":
        skip = True
        things(chrt)
        chrt = []
        print()
    else:
        chrt.append(line)

things(chrt)
