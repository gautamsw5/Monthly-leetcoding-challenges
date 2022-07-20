from bisect import *
class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        ans = 0
        index = defaultdict(list)
        for i in range(len(s)):
            index[s[i]].append(i)
        for word in words:
            i = 0
            m = len(word)
            j = -1
            while i < m:
                jj = bisect_left(index[word[i]], j+1)
                if jj < len(index[word[i]]) and j < index[word[i]][jj]:
                    j = index[word[i]][jj]
                else:
                    break
                i += 1
            if i == m:
                ans += 1
        return ans
