class Solution:
    def deleteAndEarn(self, arr: List[int]) -> int:
        arr.sort()
        f = []
        i = 0
        n = len(arr)
        while i < n:
            c = 0
            v = arr[i]
            while i < n and arr[i] == v:
                c += 1
                i += 1
            f.append([v, c])
        
        # print(f)

        n = len(f)
        dp = [[0, 0] for _ in range(n+1)]
        for i in range(n):
            if i == 0 or f[i-1][0]+1 == f[i][0]:
                dp[i+1][0] = max(dp[i][0], dp[i][1])
                dp[i+1][1] = dp[i][0] + f[i][0]*f[i][1]
            else:
                dp[i+1][0] = max(dp[i][0], dp[i][1])
                dp[i+1][1] = dp[i+1][0] + f[i][0]*f[i][1]
        return max(dp[n])
