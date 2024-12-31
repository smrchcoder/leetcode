from typing import List

#Solution 1
def maxFrequency(nums: List[int], k: int) -> int:
        # frequency=[]
        # nums.sort(reverse=True)
        # for i in range(0,len(nums)):
        #     g_for_index=nums[i]
        #     k_copy=k
        #     count=0
        #     for j in range(i+1,len(nums)):
        #         if(g_for_index-nums[j]<=k_copy):
        #             count+=1
        #             k_copy-=g_for_index-nums[j]
        #     frequency.append(count+1)
        # print(frequency)
        # return max(frequency)
#Solution2:
        nums.sort()
        left=0
        total_operations=0
        max_freq=1
        for right in range(1,len(nums)):
            total_operations+=(nums[right]-nums[right-1])*(right-left)
            while total_operations>k and left<len(nums):
                total_operations-=(nums[right]-nums[left])
                left+=1
            max_freq=max(max_freq,right-left+1)
        return max_freq

print(maxFrequency([1,4,8,13],5))
