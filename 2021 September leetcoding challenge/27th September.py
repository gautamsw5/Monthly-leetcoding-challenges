class Solution:
    def numUniqueEmails(self, arr: List[str]) -> int:
        for i in range(len(arr)):
            t = arr[i].split('@')
            address = t[0].replace(".", "")
            if "+" in address:
                address = address[0:address.index("+")]
            domain = t[1]
            arr[i] = address+"@"+domain
        return len(set(arr))
