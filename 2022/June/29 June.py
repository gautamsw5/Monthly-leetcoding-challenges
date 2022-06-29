from bisect import insort, bisect_left
class Solution:
    def reconstructQueue(self, arr: List[List[int]]) -> List[List[int]]:
        arr.sort()
        i = 0
        n = len(arr)
        while i < n and arr[i][1] != 0:
            i += 1
        ans = [arr[i]]
        used = [arr[i][0]]
        arr.pop(i)
        for i in range(len(arr)):
            for j in range(len(arr)):
                if len(used) - bisect_left(used, arr[j][0]) == arr[j][1]:
                    insort(used, arr[j][0])
                    ans.append(arr[j])
                    arr.pop(j)
                    break
        return ans
