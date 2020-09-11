import sys
import math

for line in sys.stdin:
  num = int(line)
  notNum = num
  found = {1}
  maybe = 2
  total = 1
  while maybe < notNum:
    if num % maybe == 0:
      if maybe in found:
        print('Uhh {}'.format(maybe))
      if num // maybe in found:
        print('ddd {}'.format(num // maybe))
      total += (maybe + num // maybe)
      found.add(maybe)
      found.add(num // maybe)
      notNum = num / maybe

    maybe += 1

  diff = abs(sum(divisor for divisor in found) - num)
  # diff = total - num
  if diff == 0:
    print("{} perfect".format(num))
  elif diff <= 2:
    print("{} almost perfect".format(num))
  else:
    print("{} not perfect".format(num))
