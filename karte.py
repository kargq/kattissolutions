p = set()
k = set()
h = set()
t = set()

line = input().strip()

for i in range(0, len(line), 3):
    a = line[i]
    d = line[i + 1] + line[i + 2]
    d = int(d)

    if a == "P":
        if d in p:
            print('GRESKA')
            exit()
        p.add(d)
    elif a == "K":
        if d in k:
            print('GRESKA')
            exit()
        k.add(d)
    elif a == "H":
        if d in h:
            print('GRESKA')
            exit()
        h.add(d)
    elif a == "T":
        if d in t:
            print('GRESKA')
            exit()
        t.add(d)

print(" ".join([str(13 - len(x)) for x in [p, k, h, t]]))
