class Solution:
    def brokenCalc(self, x: int, y: int) -> int:
        ans = 0
        while x != y:
            if x > y:
                return ans + x - y
            if y % 2 == 0:
                y = y // 2
            else:
                y += 1
            ans += 1
        return ans
