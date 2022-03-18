class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        f = [0]*26
        p = 0
        for c in s:
            f[ord(c)-ord('a')] += 1
        for i in range(len(s)):
            if s[i] < s[p]:
                p = i
            f[ord(s[i]) - ord('a')] -= 1
            if f[ord(s[i]) - ord('a')] == 0:
                break
        if len(s) == 0:
            return ""
        else:
            return s[p] + self.removeDuplicateLetters(s[p+1:].replace(s[p], ""))
