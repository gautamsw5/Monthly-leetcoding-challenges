class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        n = len(arr)
        ans = [[arr[0], arr[1]]]
        for i in range(1, n-1):
            if arr[i+1] - arr[i] == ans[-1][1] - ans[-1][0]:
                ans.append([arr[i], arr[i+1]])
            elif arr[i+1] - arr[i] < ans[-1][1] - ans[-1][0]:
                ans = [[arr[i], arr[i+1]]]
        return ans
