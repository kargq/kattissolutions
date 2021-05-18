def countStuff(a):
  zeroes = 0
  ones = 0
  n = ord(a)
  for i in range(7):
    shifted = n >> i 
    this_bit = shifted & 1
    if this_bit:
      ones += 1
    else:
      zeroes += 1
  return (zeroes, ones)


import sys 

for line in sys.stdin:
  tzeroes = 0
  tones = 0
  line = line.strip()
  for c in line:
    (cz, co) = countStuff(c)
    tzeroes += cz 
    tones += co

  if tzeroes % 2 == 0 and tones % 2 == 0:
    print("free")
  else:
    print("trapped")