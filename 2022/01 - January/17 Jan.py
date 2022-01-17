class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        n = len(pattern)
        arr = s.split()
        if len(arr) != n:
            return 0
        hashmap = {}
        revmap = {}
        for i in range(n):
            if pattern[i] in hashmap and hashmap[pattern[i]] != arr[i]:
                return 0
            if arr[i] in revmap and revmap[arr[i]] != pattern[i]:
                return 0
            revmap[arr[i]] = pattern[i]
            hashmap[pattern[i]] = arr[i]
        return 1
