import math

[n, r, k] = [int(x) for x in input().strip().split(" ")]

if k < r:
    left = max(n - r, 0) # left after getting to registration desk 

    half = math.ceil(left / 2) 

    to_r = r + half * 2

    print(to_r + r)
else:
    # first go to k

    # then go to r completing distance, and then back

    straight = abs(r - k) # covered in straight line 

    # covered k + straight so far, need to cover rest

    left = max(0, n - (k + straight)) 

    half = math.ceil(left / 2)

    left_cover = half * 2 

    # so far k + straight + left_cover, now just gotta get back to ground

    print(k + straight + left_cover + r)