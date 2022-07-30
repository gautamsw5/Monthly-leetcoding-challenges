class Solution:
    def wordSubsets(self, arr: List[str], brr: List[str]) -> List[str]:
        f = defaultdict(int)
        for b in brr:
            ff = defaultdict(int)
            for c in b:
                ff[c] += 1
                f[c] = max(f[c], ff[c])
        ans = []
        for a in arr:
            x = 1
            ff = defaultdict(int)
            for c in a:
                ff[c] += 1
            for c in f:
                if ff[c] < f[c]:
                    x = 0
                    break
            if x:
                ans.append(a)
        return ans
