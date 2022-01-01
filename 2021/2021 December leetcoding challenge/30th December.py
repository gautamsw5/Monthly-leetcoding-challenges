class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        r = 0
        for i in range(k):
            r = (r*10+1)%k
            if r == 0:
                return i+1
        return -1
