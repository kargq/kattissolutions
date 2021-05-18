n1 = input().strip()
n2 = input().strip()

diff = abs(len(n1) - len(n2))

if len(n1) < len(n2):
    n1 = "0" * diff + n1

if len(n1) > len(n2):
    n2 = "0" * diff + n2

res1 = ""
res2 = ""

for (c1, c2) in zip(reversed(n1), reversed(n2)):
    if c1 > c2:
        res1 = c1 + res1
    elif c1 < c2:
        res2 = c2 + res2
    else:
        res1 = c1 + res1
        res2 = c2 + res2

print(int(res1) if res1 != "" else "YODA")
print(int(res2) if res2 != "" else "YODA")
