class Solution:
    def solve(self, w):
        if len(w) == 1:
            return 1
        if w in self.dp:
            return self.dp[w]
        ans = 1
        for i in range(len(w)):
            ww = w[:i] + w[i+1:]
            if ww in self.words:
                ans = max(ans, 1 + self.solve(ww))
        self.dp[w] = ans
        return ans
    
    def longestStrChain(self, words: List[str]) -> int:
        self.words = set(words)
        ans = 1
        self.dp = {}
        for w in words:
            ans = max(ans, self.solve(w))
        return ans
