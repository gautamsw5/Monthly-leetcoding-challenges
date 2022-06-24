class Solution:
    def isPossible(self, arr: List[int]) -> bool:
        m = max(arr)
        s = sum(arr)
        n = len(arr)
        if n == 1 and m != 1:
            return 0
        elif n == 1:
            return 1
        while m > 1:
            # print(arr)
            for i in range(n):
                if arr[i] == m:
                    x = (s - arr[i])
                    f = arr[i] // x
                    if f == 0 or (f == 1 and f*x == arr[i]):
                        return 0
                    elif f*x == arr[i]:
                        arr[i] -= (f-1)*x
                    else:
                        arr[i] -= f*x
                    if arr[i] <= 0:
                        return 0
                    break
            m = max(arr)
            s = sum(arr)
        return m == 1 and min(arr) == 1
