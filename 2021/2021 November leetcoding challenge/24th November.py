class Solution:
    def intervalIntersection(self, arr: List[List[int]], brr: List[List[int]]) -> List[List[int]]:
        ans = []
        i, j, n, m = 0, 0, len(arr), len(brr)
        while i < n and j < m:
            if arr[i][1] < brr[j][0]:
                i += 1
            elif brr[j][1] < arr[i][0]:
                j += 1
            else:
                ans.append([max(arr[i][0], brr[j][0]), min(arr[i][1], brr[j][1])])
                if i+1 < n and arr[i+1][0] <= brr[j][1]:
                    i += 1
                else:
                    j += 1
        return ans
