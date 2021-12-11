mod = 10**9 + 7

def div(m, a, b):
    lcm = a*b // math.gcd(a, b)
    return m // a + m // b - m // lcm

class Solution:
    def nthMagicalNumber(self, n: int, a: int, b: int) -> int:
        l, r = 1, n*a
        while l < r:
            m = (l+r) // 2
            c = div(m, a, b)
            if c < n:
                l = m + 1
            else:
                r = m
        # print(n, a, b, "->", r)
        return r % mod
