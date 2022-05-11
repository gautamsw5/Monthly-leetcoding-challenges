class Solution:
    def countVowelStrings(self, n: int) -> int:
        if n==1:
            return 5
        dp={}
        dp[(1,0)]=5
        dp[(2,1)]=5
        dp[(2,2)]=4
        dp[(2,3)]=3
        dp[(2,4)]=2
        dp[(2,5)]=1
        for i in range(3,n+1):
            for j in range(1,6):
                dp[(i,j)]=dp[(i-1,j)]
                for k in range(j+1,6):
                    dp[(i,j)]+=dp[(i-1,k)]
        return dp[(n,1)]+dp[(n,2)]+dp[(n,3)]+dp[(n,4)]+dp[(n,5)]
