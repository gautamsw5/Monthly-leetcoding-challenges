from sortedcontainers import SortedSet
mod = 10**9 + 7
def process(arr, idx):
    """
    merge intervals starting at arr[idx]
    """
    i = idx+1
    while i < len(arr):
        if arr[i][0] <= arr[idx][1]:
            arr[idx][1] = max(arr[idx][1], arr[i][1])
            del arr[i]
        else:
            break
    return arr
def insert(arr, pair):
    """
    insert pair of y points inside interval array arr
    """
    if len(arr)==0:
        arr.append(pair)
        return arr
    if pair[0] <= arr[0][0]:
        arr.insert(0, pair)
        return process(arr, 0)
    for idx in range(len(arr)):
        if pair[0] >= arr[idx][0] and (idx+1==len(arr) or pair[0] < arr[idx+1][0]):
            arr.insert(idx+1, pair)
            arr = process(arr, idx)
            return process(arr, idx+1)
    arr.append(pair)
    print(arr)
    return process(arr, max(0, len(arr)-2))
class Solution:
    def rectangleArea(self, arr: List[List[int]]) -> int:
        xs = SortedSet([]) # Store all x points
        for r in arr:
            xs.add(r[0])
            xs.add(r[2])
        hist = []
        xs = list(xs)
        for i in range(1, len(xs)):
            hist.append([xs[i-1], xs[i], []]) # An interval of consecutive x points with list to store sorted disjoint y point pairs
        for r in arr:
            for x in hist:
                if x[0] >= r[0] and x[1] <= r[2]:
                    # print(x[:2], [r[1], r[3]])
                    x[2] = insert(x[2], [r[1], r[3]])
                    # print(hist, x[:2], [r[1], r[3]])
        ans = 0
        for x in hist:
            for y in x[2]:
                ans = (ans + (x[1]-x[0])*(y[1]-y[0])) % mod
        # print(xs)
        # print(hist)
        return ans
