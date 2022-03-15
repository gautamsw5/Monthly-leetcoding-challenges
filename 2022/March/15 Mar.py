class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        x = 0
        a = ""
        for c in s:
            if c == '(':
                x += 1
                a += c
            elif c == ')':
                x -= 1
                if x >= 0:
                    a += c
                else:
                    x += 1
            else:
                a += c
        # print(a)
        b = ""
        x = 0
        for c in a[::-1]:
            if c == ')':
                x += 1
                b += c
            elif c == '(':
                x -= 1
                if x >= 0:
                    b += c
                else:
                    x += 1
            else:
                b += c
        return b[::-1]
