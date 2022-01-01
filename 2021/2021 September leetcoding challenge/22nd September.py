from functools import lru_cache

class Solution:
    @lru_cache
    def solve(self, i, tup):
        if i == self.n:
            return 0
        ans = self.solve(i+1, tup)
        tup = list(tup)
        for c in self.arr[i]:
            if tup[ord(c)-ord('a')] == 1:
                return ans
            else:
                tup[ord(c)-ord('a')] = 1
        return max(ans, len(self.arr[i]) + self.solve(i+1, tuple(tup)))
    
    def maxLength(self, arr: List[str]) -> int:
        self.arr = arr
        self.n = len(arr)
        return self.solve(0, tuple([0]*26))
    
    def maxLength_Iterative(self, arr: List[str]) -> int:
        ans = 0
        for x in range(1 << len(arr)):
            freq = set()
            flag = False
            for i in range(len(arr)):
                if x % 2 == 0:
                    for c in arr[i]:
                        if c in freq:
                            flag = True
                            break
                        freq.add(c)
                if flag:
                    break
                x = x // 2
            if not flag:
                ans = max(ans, len(freq))
        return ans
