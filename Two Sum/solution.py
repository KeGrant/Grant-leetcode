class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        rL = []
        for i, element in enumerate(nums):
            compleEle = target - element
            if (compleEle in nums):
                j = nums.index(compleEle)
                if i != j:
                    rL = [i, j]
                    return rL
