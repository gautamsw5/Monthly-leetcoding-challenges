def solve(arr):
    n = len(arr)
    for x in range(1<<n):
        s1 = s2 = 0
        for i in range(n):
            if (x>>i)&1:
                s1 += arr[i]
            else:
                s2 += arr[i]
        if s1 == s2:
            return 1
    return 0
class Solution:
    def makesquare(self, arr: List[int]) -> bool:
        s = sum(arr)
        if s % 4 != 0:
            return 0
        self.t = s // 4
        self.arr = arr
        self.n = len(arr)
        for x in range(1<<self.n):
            a = []
            b = []
            for i in range(self.n):
                if (x>>i)&1:
                    a.append(arr[i])
                else:
                    b.append(arr[i])
            if sum(a) == sum(b) and solve(a) and solve(b):
                return 1
        return 0
