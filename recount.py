import sys

ballot = {}

mx = 0
name = None

for line in sys.stdin:
    line = line.strip()
    if line == "***":
        break
    else:
        if line in ballot:
            ballot[line] += 1
        else:
            ballot[line] = 1

        if ballot[line] > mx:
            mx = ballot[line]
            name = line
        elif ballot[line] == mx:
            name = None

if name:
    print(name)
else:
    print("Runoff!")
