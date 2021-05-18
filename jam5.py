# Google codejam 2021 Qualification, problem 4

import math
from functools import lru_cache
import random

# Probability that some question is answered incorrectly
# s - skill level
# q - question difficulty


rand_s = [random.uniform(-3, 3) for _ in range(100)]
rand_q = [random.uniform(-3, 3) for _ in range(1000)]

@lru_cache
def f(x):
    # x = s - q
    return 1 / (1 + math.exp(-x))

@lru_cache
def fp(x):
    # x = s - q
    return f(x) * (1 - f(x))


def sum_given_

def find_q(j, data):
    p = sum(data[i][j] for i in range(100)) / 100  # Actual correct ratio


    


t = int(input())
p = float(input())  # Do I need this? no

for case in range(1, t + 1):
    students = [[x == "1" for x in input().strip()] for _ in range(100)]

    # 100 players
    # 1000 questions

    # Let's find the probability of each question being answered correctly.

    # Or not? Can I not just find the correct ratio for each student and choose closest to 50

    # or a combination of this and person furthest from the expected distribution

    # Need some way to find difficulty for each question... dirty way might work? Like just how many got it right

    # there's for sure a way to approximate, some kinda optimization

    # Use a random distribution for either difficulty or skill, and optimize the other. We know the average probability

    for stu in students:
        ratio = sum(stu) / 1000  # Close to 50 is suspicious

    print("Case #{}: {}".format(case, case))
