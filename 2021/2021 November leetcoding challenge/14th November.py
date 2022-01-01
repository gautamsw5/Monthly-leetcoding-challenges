class CombinationIterator:

    def __init__(self, arr: str, n: int):
        self.arr = arr
        self.n = n
        self.m = len(arr)
        self.combs = [self.getComb(i) for i in range(1<<self.m) if self.bitcount(i) == self.n]
        self.combs.sort()
        
    def bitcount(self, x):
        c = 0
        while x > 0:
            c += (x & 1)
            x = x >> 1
        return c
    
    def getComb(self, comb):
        s = ""
        for i in range(self.m):
            if (comb & 1):
                s += self.arr[i]
            comb = comb >> 1
        return s
    
    def next(self) -> str:
        return self.combs.pop(0)

    def hasNext(self) -> bool:
        return len(self.combs) > 0

# Your CombinationIterator object will be instantiated and called as such:
# obj = CombinationIterator(characters, combinationLength)
# param_1 = obj.next()
# param_2 = obj.hasNext()
