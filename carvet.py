import sys 
sys.setrecursionlimit(10**9)

[m, n] = [int(x) for x in input().strip().split(" ")]

rows = m
cols = n

empty = -1  # Only 1 empty
blocked = -2

grid = [[int(x) for x in input().strip().split(" ")] for _ in range(rows)]

[r, c] = [int(x) for x in input().strip().split(" ")]

cars = {}

unvisited = set()

for rn, row in enumerate(grid):
    for cn, x in enumerate(row):
        if x != empty and x != blocked:
            unvisited.add(x)
            if x in cars:
                cars[x].append((rn, cn))
            else:
                cars[x] = [(rn, cn)]


def clear(r, c):
    no = ([], False)
    if r < 0 or r >= rows or c < 0 or c >= cols:
        return no
    if grid[r][c] == blocked:
        return no
    if grid[r][c] == empty:
        return [[], True]
    if len(unvisited) == 0:
        return no

    n = grid[r][c]

    if n not in unvisited:
        return no
    else:
        unvisited.remove(n)

    (r2, c2) = cars[n][0] if cars[n][0] != (r, c) else cars[n][1]

    if r2 != r:
        # vertical move
        rmx = max(r2, r)
        rmn = min(r2, r)
        col = c

        if rmn == r:
            # can only clear by going up
            up = (rmx + 1, col)

            (up_arr, up_clear) = clear(*up)

            if up_clear:
                return ([n] + up_arr, True)

        if rmx == r:
            # Can only clear by going down
            down = (rmn - 1, col)

            (down_arr, down_clear) = clear(*down)

            if down_clear:
                return ([n] + down_arr, True)
    else:
        # horizontal move
        cmx = max(c2, c)
        cmn = min(c2, c)
        row = r

        if cmn == c:
            # can only clear by going right
            right = (row, cmx + 1)

            (right_arr, right_clear) = clear(*right)

            if right_clear:
                return ([n] + right_arr, True)

        if cmx == c:
            # can only clear by going left
            left = (row, cmn - 1)

            (left_arr, left_clear) = clear(*left)

            if left_clear:
                return ([n] + left_arr, True)

    return no
    # Check if move forward
    # Check if move backward


(arr, clr) = clear(r - 1, c - 1)

if clr:
    print(" ".join(map(str, reversed(arr))))
    pass
else:
    print("impossible")
