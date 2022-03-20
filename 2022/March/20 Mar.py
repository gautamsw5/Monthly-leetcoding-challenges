class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        ans = -1
        for x in [tops[0], bottoms[0]]:
            c = 0
            c1 = 0
            n = len(tops)
            for i in range(n):
                if tops[i] != x and bottoms[i] != x:
                    c = -1
                    c1 = -1
                    break
                if tops[i] != x:
                    c += 1
                if bottoms[i] != x:
                    c1 += 1
            if c != -1 and (ans == -1 or c < ans or n - c < ans):
                ans = min(c, n - c)
            if c1 != -1 and (ans == -1 or c1 < ans or n - c1 < ans):
                ans = min(c1, n - c1)
        return ans
