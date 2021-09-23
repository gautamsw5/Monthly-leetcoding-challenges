class Solution:
    def breakPalindrome(self, s: str) -> str:
        if len(s) == 1:    # Impossible case
            return ""
        for i in range(len(s)):
            if s[i] != 'a' and i != len(s) - i - 1:   # Not center and not 'a', if you change center of odd palindrome, it will still be a palindrome
                return s[:i] + "a" + s[i+1:]   # Replace char at i with "a"
        return s[:-1] + "b"                    # All 'a' in the string except possibly center if odd length so change last char to "b"
