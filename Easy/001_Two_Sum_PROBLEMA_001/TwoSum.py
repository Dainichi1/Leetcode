class Solution:
    def TwoSum(self, nums: list[int], target: int) -> list[int]:
        map_nums = {}

        for i, num in enumerate(nums):
            complement = target - num

            if complement in map_nums:
                return [map_nums[complement], i]

            map_nums[num] = i

        return []
