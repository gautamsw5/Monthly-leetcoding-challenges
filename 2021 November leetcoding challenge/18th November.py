class Solution:
    def findDisappearedNumbers(self, arr: List[int]) -> List[int]:
        n = len(arr)
        arr = set(arr)
        ans = []
        for i in range(1, n+1):
            if not i in arr:
                ans.append(i)
        return ans
