class Solution:
    def checkPossibility(self, arr: List[int]) -> bool:
        p = -10**5
        sk = []
        f = 0
        for i in range(len(arr)):
            if arr[i] >= p:
                p = arr[i]
            else:
                sk.append(i)
                sk.append(i-1)
                f += 1
                if f > 2:
                    break
        # print(sk)
        if f == 0:
            return 1
        for s in sk:
            p = -10**5
            f = 1
            for i in range(len(arr)):
                if i == s:
                    continue
                if arr[i] >= p:
                    p = arr[i]
                else:
                    f = 0
                    break
            if f:
                return 1
        return 0
