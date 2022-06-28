class Solution:
    def minDeletions(self, s: str) -> int:
        f = [0]*26
        for c in s:
            f[ord(c)-ord('a')] += 1
        f.sort()
        while len(f) > 0 and f[0] == 0:
            f.pop(0)
        # print(f)
        n = len(f)
        m = f[n-1]
        st = set()
        ans = 0
        for i in range(n-1, -1, -1):
            if f[i] in st:
                ans += f[i] - max(0, min(st)-1)
                st.add(max(0, min(st)-1))
            else:
                st.add(f[i])
        return ans
