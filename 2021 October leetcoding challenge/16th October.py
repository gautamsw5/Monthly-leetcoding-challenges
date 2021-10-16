class Solution:
    def solve(self, arr, i, K, dp):
        ans = 0
        for k in range(1, K+1):
            jm = None
            for i in range(len(arr)-1, -1, -1):
                if jm == None:
                    jm = i
                elif arr[i][1] + dp[i+1][k-1] > arr[jm][1] + dp[jm+1][k-1]:
                    jm = i
                dp[i][k] = max(dp[i+1][k], arr[jm][1]-arr[i][0]+dp[jm+1][k-1])
                # for j in range(i, len(arr)):
                #     dp[i][k] = max(dp[i][k], arr[j][1]-arr[i][0]+dp[j+1][k-1])
                ans = max(ans, dp[i][k])
        return ans
    def maxProfit(self, A):
        i = 0
        T = []
        N = len(A)
        K = 2
        while i < N:
            while i+1 < N and A[i+1] <= A[i]:
                i += 1
            buy = A[i]
            i += 1
            if i < N:
                while i+1 < N and A[i+1] >= A[i]:
                    i += 1
                sell = A[i]
                T.append((buy, sell))
                i += 1
        # print(T)
        return self.solve(T, 0, K, [[0 for j in range(K+1)] for i in range(len(T)+1)])
