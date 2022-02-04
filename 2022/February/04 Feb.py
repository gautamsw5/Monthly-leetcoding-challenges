class Solution:
    def findMaxLength(self, arr: List[int]) -> int:
        ans = 0
        n = len(arr)
        """
        a, b is prefix sum of 0's, 1's resp.
        find 2*max(a[j]-a[i]) where a[j] - a[i] = b[j] - b[i]
        rearrange:   a[j] - b[j] = a[i] - b[i]
        for every k find 2*max(a[j] - a[i]) where a[j] - b[j] = k
        """
        a = [0]
        b = [0]
        f = defaultdict(set)
        f[0].add(0)
        for i in range(n):
            if arr[i] == 0:
                a.append(a[-1]+1)
                b.append(b[-1])
            else:
                a.append(a[-1])
                b.append(b[-1]+1)
            f[a[i+1]-b[i+1]].add(a[i+1])
        for k in f:
            ans = max(ans, 2*max(f[k])-2*min(f[k]))
        return ans
