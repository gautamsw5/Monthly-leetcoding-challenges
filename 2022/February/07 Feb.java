class Solution {
    public char findTheDifference(String S, String T)
    {
        char[] s=S.toCharArray();
        char[] t=T.toCharArray();
        int[] arr=new int[26];
        int i=0;
        for(i=0;i<s.length;i++)
        {
            arr[s[i]-'a']--;
            arr[t[i]-'a']++;
        }
        arr[t[i]-'a']++;
        for(i=0;i<26;i++)
        {
            if(arr[i]==1)
            {
                return (char)(i+(int)'a');
            }
        }
        return 'a';
    }
}
