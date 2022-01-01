from collections import defaultdict

class Solution:
    def findNumOfValidWords(self, words: List[str], puzzles: List[str]) -> List[int]:
        n = len(words)
        m = len(puzzles)
        
        freq = defaultdict(int)   # Hash the words in this dictionary
        
        for w in words:
            freq[tuple(sorted(list(set(w))))] += 1
        
        ans = [0]*m
        
        for i, w in enumerate(puzzles):
            puzzleSet = list(w)
			# Try all subsets of puzzles[i] because 2nd condition in question is word should be subset of puzzle
            for x in range(1 << (len(puzzleSet)-1)):  # Using the fact that length of puzzles[i] is 7 --> 64 iterations (2^6)
                puzzleSubSet = [w[0]]   # First letter should be included in the subset of puzzles[i]
                for c in puzzleSet[1:]:  # --> 6 iterations
                    if x & 1:    # Select the characters whose bit is set to 1
                        puzzleSubSet.append(c)
                    x = x >> 1  # Divide x by 2
                ans[i] += freq[tuple(sorted(puzzleSubSet))]   # Add answer of that subset for puzzles[i]
        return ans
