cases = int(input())


def check(path):
    bag = []

    for c in path:
        if c == ".":
            pass
        elif c == "$":
            bag.append("$")
            pass
        elif c == "|":
            bag.append("|")
            pass
        elif c == "*":
            bag.append("*")
            pass
        elif c == "t":
            if len(bag) == 0 or bag.pop() != "|":
                return False
            pass
        elif c == "j":
            if len(bag) == 0 or bag.pop() != "*":
                return False
            pass
        elif c == "b":
            if len(bag) == 0 or bag.pop() != "$":
                return False
            pass

    return len(bag) == 0


for _ in range(cases):
    if check(input().strip()):
        print("YES")
    else:
        print("NO")
