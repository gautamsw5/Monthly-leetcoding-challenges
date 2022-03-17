class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        ans = 0
        x = 0
        n = len(s)
        for i in range(n):
            if s[i] == '(':
                x += 1
            else:
                x -= 1
                if s[i-1] == '(':
                    ans += 1 << x
        return ans
