class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        freq = [0]*60
        for i in time:
            freq[i%60] += 1
        ans = (freq[0]*(freq[0]-1)) // 2 + (freq[30]*(freq[30]-1)) // 2
        for i in range(1, 30):
            ans += freq[i]*freq[60-i]
        return ans
