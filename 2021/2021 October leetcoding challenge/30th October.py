class Solution:
    def longestDupSubstringK(self, s: str, k: int) -> str:
        w = s[:k]
        st = set([w])
        for i in range(k, len(s)):
            w = w[1:] + s[i]
            if w in st:
                return w
            else:
                st.add(w)
        return ""
    def longestDupSubstring(self, s: str) -> str:
        l, r = 0, len(s)-1
        while l <= r:
            m = (l+r) // 2
            f = self.longestDupSubstringK(s, m)
            if f and not self.longestDupSubstringK(s, m+1):
                return f
            elif f:
                l = m+1
            else:
                r = m-1
        return ""
