[r, c] = [int(rn) for rn in input().strip().split(" ")]
map = [input().strip() for _ in range(r)]

visited = set()
# visited = [[False] * c for _ in range(r)]


def mget(rn, cn):
    return map[rn][cn]


def nbrs(rn, cn):
    return filter(lambda t: t[0] >= 0 and t[0] < r and t[1] >= 0 and t[1] < c, [(rn + 1, cn), (rn - 1, cn), (rn, cn - 1), (rn, cn + 1)])


def dfs(rn, cn):
    visited.add((rn, cn))

    for nbr in nbrs(rn, cn):
        if nbr not in visited and (mget(*nbr) == 'L' or mget(*nbr) == 'C'):
            dfs(*nbr)


count = 0

for row in range(r):
    for col in range(c):
        if (row, col) not in visited and mget(row, col) == "L":
            count += 1
            dfs(row, col)

print(count)