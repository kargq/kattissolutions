import sys 

found = set()

for line in sys.stdin:
    words =  [x for x in line.strip().split(" ")]

    for index, word in enumerate(words):
        if word.lower() in found:
            words[index] = "."
        else:
            found.add(word.lower())

    print(" ".join(words))