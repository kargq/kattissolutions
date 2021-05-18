[n, k] = [int(x) for x in input().strip().split(" ")]

commands = input().strip().split(" ")

states = [0]
i = 0
while i < len(commands):
    cmd = commands[i]
    if cmd == "undo":
        i += 1
        undo = int(commands[i])
        new_end = max(0, len(states) - undo)
        states = states[:new_end]
    else:
        rotate = int(cmd)
        prev = states[-1]
        new_state = (prev + rotate) % n
        states.append(new_state)
    i += 1


print(states[-1])
