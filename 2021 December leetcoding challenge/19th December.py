def get(s, l):
    c = 0
    for i in range(l, len(s)):
        if s[i] == '[':
            c += 1
        elif s[i] == ']':
            c -= 1
            if c == 0:
                return i
    return -1
class Solution:
    def decodeString(self, s: str) -> str:
        v = ""
        pre = ""
        for i in range(len(s)):
            if s[i] >= '0' and s[i] <= '9':
                v += s[i]
            elif v != "":
                break
            else:
                pre += s[i]
        if v == "":
            return s
        x = get(s, i)
        return pre + int(v) * self.decodeString(s[i+1:x]) + self.decodeString(s[x+1:])
