class Solution:
    def candy(self, arr: List[int]) -> int:
        n = len(arr)
        candies = [0]*n
        q = []
        for i in range(n):
            if (i == 0 or arr[i-1] >= arr[i]) and (i == n-1 or arr[i+1] >= arr[i]):
                candies[i] = 1
                q.append(i)
        while q:
            u = q.pop(0)
            if u-1 >= 0 and arr[u-1] > arr[u] and candies[u-1] < candies[u] + 1:
                candies[u-1] = candies[u] + 1
                q.append(u-1)
            if u+1 < n and arr[u+1] > arr[u] and candies[u+1] < candies[u] + 1:
                candies[u+1] = candies[u] + 1
                q.append(u+1)
        return sum(candies)
