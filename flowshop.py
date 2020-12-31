[n, m] = [int(x) for x in input().strip().split(" ")]

arr = [[int(x) for x in input().strip().split(" ")] for _ in range(n)]

times = [0] * n
prev = 0

# t = 0
for j in range(m):
    # times: when the last stage finished for each i 
    new_prev = None 
    for i in range(n):
        p = arr[i][j]
        if times[i] < prev:
            times[i] = p + prev
        else:
            times[i] += p
        prev = times[i]
        new_prev = min(new_prev, prev) if new_prev else prev 
    prev = new_prev

print(" ".join([str(x) for x in times]))