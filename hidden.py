[pas, word] = [x for x in input().strip().split(" ")]

expected = [x for x in reversed(pas)]

for x in word:
    if x in expected:
        if expected.pop() != x:
            print("FAIL")
            exit()

if len(expected) > 0:
    print("FAIL")
else:
    print("PASS")
