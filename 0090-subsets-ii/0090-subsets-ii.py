class Solution:
    def powerset(self, nums, ind, ss, ps):
        if ind == len(nums):
            ps.append(ss.copy())
            return
        ss.append(nums[ind])
        self.powerset(nums, ind + 1, ss, ps)
        ss.pop()
        self.powerset(nums, ind + 1, ss, ps)

    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ps, ss = [], []
        nums.sort()
        self.powerset(nums, 0, ss, ps)
        res = list()
        for i in ps:
            if i not in res:
                res.append(i)
        return res