class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        arr = []
        for i in trips:
            arr.append([i[1], i[0]])
            arr.append([i[2], -i[0]])
        arr.sort()
        cap = 0
        for i in arr:
            cap += i[1]
            if cap>capacity:
                return False
        return True
