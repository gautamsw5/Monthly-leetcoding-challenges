class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        mergedIntervals = []
        i = 0
        n = len(intervals)
        while i < n:
            cur = list(intervals[i])
            i += 1
            while i < n and cur[1] >= intervals[i][0]:
                cur[1] = max(cur[1], intervals[i][1])
                i += 1
            mergedIntervals.append(cur)
        return mergedIntervals
