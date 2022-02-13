import itertools
class Solution:
    def subsets(self, arr: List[int]) -> List[List[int]]:
        arr=list(set(arr))
        ans=[[]]
        for i in range(1,len(arr)+1):
            ans+=list(itertools.combinations(arr,i))
        return ans
