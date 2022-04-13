class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        IS=0
        IE=n
        JS=0
        JE=n
        x=1
        mat=[[0 for i in range(n)] for j in range(n)]
        while IS<IE and JS<JE:
            i=IS
            j=JS
            while j<JE:
                mat[i][j]=x
                x=x+1
                j=j+1
            i=IS+1
            j=JE-1
            while i<IE:
                mat[i][j]=x
                x=x+1
                i=i+1
            i=IE-1
            j=JE-2
            while j>=JS:
                mat[i][j]=x
                x=x+1
                j=j-1
            i=IE-2
            j=JS
            while i>=IS+1:
                mat[i][j]=x
                x=x+1
                i=i-1
            IS=IS+1
            JS=JS+1
            IE=IE-1
            JE=JE-1
        return mat
