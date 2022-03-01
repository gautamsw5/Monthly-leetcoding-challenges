class Solution:
    def countBits(self, n: int) -> List[int]:
        arr = [0, 1]
        for i in range(2, n+1):
            arr.append(arr[i>>1] + (i&1))
        return arr[:n+1]
