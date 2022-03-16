class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        s = []
        i = 0
        j = 0
        n = len(pushed)
        while True:
            if len(s) > 0 and s[-1] == popped[j]:
                j += 1
                s.pop(-1)
            elif i < n:
                s.append(pushed[i])
                i += 1
            else:
                return len(s) == 0 and j == len(pushed)
        return True
