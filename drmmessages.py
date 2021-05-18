msg = input().strip()

msg1 = msg[:len(msg)//2]
msg2 = msg[len(msg)//2:]

a = ord('A')
rotate1 = sum(ord(c) - a for c in msg1)
rotate2 = sum(ord(c) - a for c in msg2)

rtd1 = [chr((ord(c) - a + rotate1) % 26 + a) for c in msg1]
rtd2 = [chr((ord(c) - a + rotate2) % 26 + a) for c in msg2]

res = []

for (c, rot) in zip(rtd1, rtd2):
    rotate_val = ord(rot) - a 
    res.append(chr((ord(c) - a + rotate_val) % 26 + a))

print("".join(res))
