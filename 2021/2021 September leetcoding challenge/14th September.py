class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        k = []
        s = list(s)
        for c in s:
            if (c >= 'a' and c <= 'z') or (c >= 'A' and c <= 'Z'):
                k.append(c)
        k = k[::-1]
        p = 0
        for (i, c) in enumerate(s):
            if (c >= 'a' and c <= 'z') or (c >= 'A' and c <= 'Z'):
                s[i] = k[p]
                p += 1
        return ''.join(c for c in s)
