class Solution {
    public boolean validPalindrome(String s)
    {
        int i=0,j=s.length()-1,f=0;
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                if(f==0)
                {
                    f=1;
                    if(s.charAt(i)==s.charAt(j-1))
                    {
                        int a=i+1,b=j-2;
                        while(a<b)
                        {
                            if(s.charAt(a)==s.charAt(b))
                            {
                                a++;
                                b--;
                            }
                            else
                            {
                                break;
                            }
                        }
                        if(a>=b)
                        {
                            return true;
                        }
                    }
                    if(s.charAt(i+1)==s.charAt(j))
                    {
                        int a=i+2,b=j-1;
                        while(a<b)
                        {
                            if(s.charAt(a)==s.charAt(b))
                            {
                                a++;
                                b--;
                            }
                            else
                            {
                                break;
                            }
                        }
                        if(a>=b)
                        {
                            return true;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}
