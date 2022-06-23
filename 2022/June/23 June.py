from heapq import *
class Solution:
    def scheduleCourse(self, arr: List[List[int]]) -> int:
        arr.sort(key = lambda x : (x[1], x[0]))
        day = 0
        ans = 0
        pq = []
        heapify(pq)
        for dur, las in arr:
            if day+dur <= las:
                day += dur
                ans += 1
                heappush(pq, -dur)
            elif pq and dur < -pq[0]:
                day += heappop(pq) + dur
                heappush(pq, -dur)
        return ans
