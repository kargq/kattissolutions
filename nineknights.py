import sys

board = [line.strip() for line in sys.stdin]


def gen_moves(r, c):
    return filter(lambda t: t[0] >= 0 and t[0] < 5 and t[1] >= 0 and t[1] < 5, [
        (r + 2, c + 1),
        (r - 2, c + 1),
        (r + 2, c - 1),
        (r - 2, c - 1),
        (r + 1, c + 2),
        (r - 1, c + 2),
        (r + 1, c - 2),
        (r - 1, c - 2)
    ])



valid = True
count = 0

for r, row in enumerate(board):
    for c, col in enumerate(row):
        if col == 'k':
            count += 1
            for move in gen_moves(r, c):
                if board[move[0]][move[1]] == 'k':
                    valid = False
                    break

if count == 9 and valid:
    print("valid")
else:
    print("invalid")