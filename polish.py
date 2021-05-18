import sys


def is_int(s):
    try:
        int(s)
        return True
    except ValueError:
        return False


def eval(exp, stack):
    # print(exp, stack)
    if len(exp) == 0:
        return 
    if exp[-1] in ['+', "*", "-"]:
        symbol = exp.pop()
        ex1 = stack.pop()
        ex2 = stack.pop()

        if is_int(ex1) and is_int(ex2):
            res = None
            if symbol == "*":
                res = int(ex1) * int(ex2)
            elif symbol == "-":
                res = int(ex1) - int(ex2)
            else:
                res = int(ex1) + int(ex2)
            stack.append(res)
        else:
            stack.append("{} {} {}".format(symbol, ex1, ex2))
    else:
        stack.append(exp.pop())
    eval(exp, stack)



count = 1
for line in sys.stdin:
    exp = line.strip().split(" ")
    stack = []
    eval(exp, stack)
    # print(exp, stack)
    print("Case {}: {}".format(count, stack[-1]))
    count +=1

# * - + - - *
# 6 x -6 9 6 0 c
