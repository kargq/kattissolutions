import sys

first = True

def check_ap(nums):
    diff = nums[1] - nums[0]
    prev = nums[0]

    for num in nums:
        if num != prev:
            return False
        else:
            prev += diff
    return True


for line in sys.stdin:
    if not first:
        nums = [int(x) for x in line.strip().split(" ")][1:]
        if check_ap(nums):
            print("arithmetic")
        elif check_ap(sorted(nums)):
            print("permuted arithmetic")
        else:
            print("non-arithmetic")
    else:
        first = False
