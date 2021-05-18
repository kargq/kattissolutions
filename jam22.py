# Google codejam 2021 Qualification, problem 2

import re

t = int(input())

def get_thing():
    [x, y, s] = [z for z in input().strip().split(" ")]
    x = int(x)
    y = int(y)
    
    s = s.replace("?", "")
    s = re.sub(r"C+", "C", s)
    s = re.sub(r"J+", "J", s)

    # CJ - X
    # JC - Y
   
    return sum(x if s[i:i+2] == "CJ" else y for i in range(len(s) - 1))

for case in range(1, t + 1):
    print("Case #{}: {}".format(case, get_thing()))