class Solution:
    def simplifyPath(self, s: str) -> str:
        i = 0
        n = len(s)
        a = []
        while i < n:
            if s[i] == '/':
                while i < n and s[i] == '/':
                    i += 1
                x = ""
                while i < n and s[i] != '/':
                    x += s[i]
                    i += 1
                if x == ".":
                    continue
                elif x == "..":
                    if len(a) > 0:
                        a.pop(-1)
                else:
                    a.append(x)
        s = "/" + '/'.join(a)
        if s[-1] == '/' and len(s) > 1:
            s = s[:-1]
        return s
