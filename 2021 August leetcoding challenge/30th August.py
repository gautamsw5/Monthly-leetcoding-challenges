class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        if len(ops)==0:
            return m*n
        a = ops[0][0]
        b = ops[0][1]
        for o in ops:
            if a > o[0]:
                a = o[0]
            if b > o[1]:
                b = o[1]
        return a*b
