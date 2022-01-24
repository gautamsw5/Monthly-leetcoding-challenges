class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        cap = 0
        sm = 0
        for i in range(len(word)):
            if word[i] == word[i].upper():
                if sm > 0:
                    return False
                cap += 1
            else:
                if cap > 1:
                    return False
                sm += 1
        return True
