def spl(c):
    return ord(c) in range(ord("!"), ord("*") + 1) or ord(c) in range(ord("["), ord("]") + 1) or c == "\\"


while True:
    try:
        n = int(input())
        s = input().rstrip("\n").rstrip("\r")

        escape = "\\" * (2 ** n - 1)

        print("".join([escape + c if spl(c) else c for c in s]))
    except EOFError:
        break
