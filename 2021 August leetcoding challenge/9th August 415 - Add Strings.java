import java.util.*;
class Solution
{
    public String addStrings(String A, String B)
    {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int n = a.length, m = b.length;
        char[] c = new char[Math.max(n, m)];
        int i = a.length - 1, j = b.length - 1, k = c.length - 1, carry = 0;
        while(i >= 0 && j >= 0)
        {
            int val = carry + a[i] + b[j] - 96;
            // System.out.println(k+" "+val+" "+carry+" -> "+(val/10));
            carry = val / 10;
            val = val % 10;
            c[k] = (char)('0' + val);
            k--;
            i--;
            j--;
        }
        while(i >= 0)
        {
            int val = carry + a[i] - 48;
            // System.out.println(k+" "+val+" "+carry+" -> "+(val/10));
            carry = val / 10;
            val = val % 10;
            c[k] = (char)('0' + val);
            k--;
            i--;
        }
        while(j >= 0)
        {
            int val = carry + b[j] - 48;
            // System.out.println(k+" "+val+" "+carry+" -> "+(val/10));
            carry = val / 10;
            val = val % 10;
            c[k] = (char)(48 + val);
            k--;
            j--;
        }
        // System.out.println(carry);
        if(carry > 0)
            return carry + new String(c);
        return new String(c);
    }
}