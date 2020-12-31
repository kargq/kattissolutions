n = int(input())

num = 1
fac = 1

for i in range(1, n + 1):
  num += 1 / fac
  fac *= i + 1

print(num)