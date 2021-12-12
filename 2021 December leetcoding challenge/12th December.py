class Solution:
    
    def canPartition(self, arr: List[int]) -> bool:
        s = sum(arr)
        if s % 2 == 1:
            return False
        s = s // 2
        if s in arr:
            return True
        arr.sort(reverse = True)
        n = len(arr)
        st = set([arr[0]])
        for i in range(1, n):
            for j in list(st):
                if arr[i] + j == s:
                    return True
                st.add(arr[i]+j)
        return s in st
