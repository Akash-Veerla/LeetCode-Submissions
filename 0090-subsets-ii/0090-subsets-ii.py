class Solution:
    def powerset(self, nums, ind, ss, ps):
        if ind == len(nums):
            ps.add(tuple(ss))
            return
        ss.append(nums[ind])
        self.powerset(nums, ind + 1, ss, ps)
        ss.pop()
        self.powerset(nums, ind + 1, ss, ps)

    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ps, ss = set(), []
        nums.sort()
        self.powerset(nums, 0, ss, ps)
        res = [list(s) for s in ps]
        return res