class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones.sort()
        while len(stones)>1:
            stones[-2]=abs(stones[-1]-stones[-2])
            del(stones[-1])
            stones.sort()
        return stones[0]
