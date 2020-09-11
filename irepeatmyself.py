import math

n = int(input())

for _ in range(n):
  line = input()
  for size in range(1, len(line) + 1):
    minMul = math.ceil(len(line) / size)
    if line in line[0:size] * minMul:
      print(size)
      break
      
