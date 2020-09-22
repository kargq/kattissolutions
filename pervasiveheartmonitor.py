import sys 
import statistics

for line in sys.stdin:
  words =  line.strip().split(" ")
  numbers = [float(word) for word in words if not word[0].isalpha()]
  names = [word for word in words if word[0].isalpha()]
  print(statistics.mean(numbers), " ".join(names))