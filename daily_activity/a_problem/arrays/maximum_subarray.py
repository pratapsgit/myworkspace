# Problem: Maximum Subarray Sum (Kadane's Algorithm)
# Given an array of integers, find the contiguous subarray with the largest sum
# and return that sum.
# Solution: Use Kadane's Algorithm, which iterates through the array, at each
# step choosing the maximum between the current element and the sum of the
# current element with the previous maximum subarray sum. This ensures an O(n)
# time complexity.

def max_subarray_sum(nums):
    if not nums:
        return 0
    
    current_max = nums[0]
    global_max = nums[0]

    for i in range(1, len(nums)):
        current_max = max(nums[i], nums[i]+current_max)
        global_max = max(current_max, global_max)

    return global_max

if __name__ == "__main__":
    print(max_subarray_sum([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
    print(max_subarray_sum([100, -3, 100]))
    print(max_subarray_sum([-3, 100, 100]))