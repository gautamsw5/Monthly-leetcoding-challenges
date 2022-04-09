class Solution:
    def topKFrequent(self, arr: List[int], k: int) -> List[int]:
        arr.sort()
        f = []
        i = 0
        n = len(arr)
        while i < n:
            f.append([arr[i], 1])
            i += 1
            while i < n and arr[i] == arr[i-1]:
                f[-1][1] += 1
                i += 1
        f.sort(key = lambda x : -x[1])
        return [x[0] for x in f[:k]]
