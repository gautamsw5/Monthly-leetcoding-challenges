class Solution:
    def largestRectangleArea(self, arr: List[int]) -> int:
        xrr = []
        i = 0
        while i<len(arr):
            xrr.append([arr[i], 0])
            while i<len(arr) and arr[i]==xrr[-1][0]:
                xrr[-1][1] += 1
                i += 1
        i = 0
        ans = 0
        while i<len(xrr):
            l = i-1
            r = i+1
            n = xrr[i][1]
            while l>=0 and xrr[l][0]>=xrr[i][0]:
                n += xrr[l][1]
                l -= 1
            while r<len(xrr) and xrr[r][0]>=xrr[i][0]:
                n += xrr[r][1]
                r += 1
            ans = max(ans, n*xrr[i][0])
            i += 1
        return ans
