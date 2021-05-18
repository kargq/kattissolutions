[b, k, g] = [int(x) for x in input().strip().split(" ")]

to_search = b - 1

search_speed = k // g 

import math 

result = math.ceil(to_search / search_speed)

print(result)