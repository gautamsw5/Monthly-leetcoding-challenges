class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        i = 0
        while i<len(s):
            cnt = 1
            while i+1<len(s) and s[i]==s[i+1]:
                cnt += 1
                i += 1
            stack.append([cnt, s[i]])
            i += 1
        i=0
        while i<len(stack):
            if stack[i][0]%k==0:
                del stack[i]
                if i>0 and i<len(stack):
                    if stack[i][1]==stack[i-1][1]:
                        stack[i-1][0] += stack[i][0]
                        del stack[i]
                        i = i - 1
                if len(stack)==0:
                    break
            else:
                stack[i][0] = stack[i][0]%k
                i = i + 1
        
        ret = ""
        for i in stack:
            ret += i[1]*i[0]
        return ret
