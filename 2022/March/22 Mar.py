class Solution:
    def getSmallestString(self, n: int, k: int) -> str:
        ans = ""
        c = 1
        while n > 0:
            while n > 0 and k-c <= (n-1)*26:
                ans += chr(c+96)
                n -= 1
                k -= c
            c += 1
        return ans
