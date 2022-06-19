class Solution:
    def suggestedProducts(self, words: List[str], s: str) -> List[List[str]]:
        words.sort()
        ans = []
        for i in range(len(s)):
            w = s[:i+1]
            l = 0
            r = len(words)-1
            res = []
            while l <= r:
                m = (l+r) // 2
                if words[m].startswith(w) and (m == 0 or not words[m-1].startswith(w)):
                    for j in range(m, m+3):
                        if j < len(words) and words[j].startswith(w):
                            res.append(words[j])
                    break
                elif words[m] > w:
                    r = m - 1
                else:
                    l = m + 1
            ans.append(res)
        return ans
