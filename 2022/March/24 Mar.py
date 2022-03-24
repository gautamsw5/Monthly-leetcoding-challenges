class Solution:
    def numRescueBoats(self, arr: List[int], lim: int) -> int:
        arr.sort()
        b=0
        i=0
        j=len(arr)-1
        while j-i+1>0:
            while j-i>0 and arr[i]+arr[j]>lim:
                b+=1
                j-=1
            while j-i>0 and arr[i]+arr[j]<=lim:
                b+=1
                j-=1
                i+=1
            if j-i==0:
                b+=1
                break
        return b
