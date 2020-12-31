[T, K] = [int(x) for x in input().strip().split(" ")]

kill = 0 

for x in range(2, T + 1):
  kill = (kill + K) % (x)

print(kill)