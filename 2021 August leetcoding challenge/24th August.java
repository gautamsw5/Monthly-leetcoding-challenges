class Solution {
    public String complexNumberMultiply(String a, String b)
    {
        String c;
        int Ax=0,Bx=0,Ay=0,By=0,i;
        for(i=0;i<a.length();i++)
        {
            if(a.charAt(i)=='+')
            {
                i++;
                break;
            }
        }
        Ax=Integer.parseInt(a.substring(0,i-1));
        Ay=Integer.parseInt(a.substring(i,a.length()-1));
        i=0;
        for(i=0;i<b.length();i++)
        {
            if(b.charAt(i)=='+')
            {
                i++;
                break;
            }
        }
        Bx=Integer.parseInt(b.substring(0,i-1));
        By=Integer.parseInt(b.substring(i,b.length()-1));
        c = Integer.toString(Ax*Bx-Ay*By)+"+"+Integer.toString(Ax*By+Ay*Bx)+"i";
        return c;
    }
}
