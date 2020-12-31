import sys

vowels = ['a', 'e', 'i', 'o', 'u', 'y']

for line in sys.stdin:
    words = line.strip().split(" ")
    for index, word in enumerate(words):
        if word[0] in vowels:
            words[index] = word + "yay"
        else:
            ind = -1
            for i, c in enumerate(word):
                if c in vowels:
                    ind = i
                    break

            if ind != -1:
                words[index] = word[ind:] + word[:ind] + "ay"

    print(" ".join(words))
