# Google codejam 2021 Qualification, problem 2

t = int(input())

def get_thing():
    [x, y, s] = [z for z in input().strip().split(" ")]
    x = int(x)
    y = int(y)
    
    # C ? ? C or J ? ? J just means all same
    # C ? ? J -->  CJ is inevitable (vice versa)
    # ? ? C --> Fill with C
    # C ? ? --> Fill with C
    
    # CJ - X
    # JC - Y
    p = 0
    to_resolve = False
    
    cost = 0
    
    # Initial ?s add nothing to cost 
    
    while p < len(s) and s[p] == '?':
        p += 1
        
    if p >= len(s):
        return cost
    
    # Got rid of the inital ?s
    
    prev = s[p]
    c = p + 1
        
    while c < len(s):
        # print(len(s), c)
        # print(s[c])
        while c < len(s) and s[c] == '?':
            c += 1

        if c >= len(s):
            break
        
        curr = s[c]
        
        if prev + curr == "CJ":
            cost += x
        elif prev + curr == "JC":
            cost += y
        
        prev = curr
        c += 1
    
    return cost

for case in range(1, t + 1):

        
    print("Case #{}: {}".format(case, get_thing()))
    
        
    
    
    # for i in range(len(s)):
    #     curr = s[i]
        
    #     if to_reolve:
    #         if curr == '?':
    #             pass
    #         else:
    #             # Found a char after question marks
                
    #             if p is None:
    #                 # Fill all prev with curr
    #                 pass # Don't add nada
    #             else:
    #                 prev = s[p]
                    
                    
                
                
    #             to_resolve = False
    #             p = i
    #     else:
    #         if curr == '?':
    #             to_resolve = True
    #         else:
    #             p = i
        
        
        # if curr == '?':
        #     to_resolve = True
        #     pass
        # elif curr == 'J':
        #     prev = curr
        #     pass
        # else:
        #     prev = curr
        #     pass 
        
        