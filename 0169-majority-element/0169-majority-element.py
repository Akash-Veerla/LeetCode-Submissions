class Solution:
    def majorityElement(self, nums: List[int]) -> int:
    # BOYER_MOORE VOTING ALGORITHM
        cand = None
        count = 0
        
        for i in nums:
            if count == 0:
                cand = i
                count = 1
            elif i == cand: count += 1
            else: count -= 1
        
        count = 0
        for i in nums:
            if i == cand: count += 1
        
        return cand if count > len(nums) // 2 else None