class Solution:
    def frequencySort(self, s: str) -> str:
        freq = {}
        for c in s:
            freq[c] = freq.get(c, 0) + 1
        freq = list(freq.items())
        freq.sort(key = lambda x : (-x[1], x[0]))
        s = ""
        for f in freq:
            s += f[0]*f[1]
        return s
