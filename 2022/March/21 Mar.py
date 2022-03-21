class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        s=set(S)
        first={i:-1 for i in s}
        last={i:-1 for i in s}
        for i in s:
            first[i]=S.index(i)
            last[i]=S.rindex(i)
        i=0
        ret=[]
        while i<len(S):
            c=1
            l=last[S[i]]
            while i<l:
                if last[S[i]]>l:
                    l=last[S[i]]
                i=i+1
                c=c+1
            if i<len(S) and i==l:
                ret.append(c)
                i=i+1
        return ret
