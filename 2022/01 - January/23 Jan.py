from bisect import *
arr = set()
v = [0]
def build(i):
    if i > 9:
        return
    v[0] = v[0]*10 + i
    arr.add(v[0])
    build(i+1)
    v[0] = v[0] // 10
for i in range(1, 10):
    build(i)
arr = sorted(arr)
class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        return arr[bisect_left(arr, low):bisect_right(arr, high)]
