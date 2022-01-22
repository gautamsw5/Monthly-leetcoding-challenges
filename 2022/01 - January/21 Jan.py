class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        arr = []
        pre = [0]
        for i in range(n):
            arr.append(gas[i]-cost[i])
            pre.append(pre[-1] + gas[i]-cost[i])
        # print(arr, pre)
        if pre[-1] < 0:
            return -1
        m = min(pre)
        if m >= 0:
            return 0
        for i in range(1, n):
            if m - pre[i] >= 0:
                return i
        return -1
