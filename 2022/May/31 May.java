class Solution
{
    public boolean hasAllCodes(String S, int k)
    {
        Set<String> set = new HashSet<>();
        for(int i=0; i<=S.length()-k; i++)
        {
            set.add(S.substring(i,i+k));
        }
        return set.size()==1<<k;
    }
}
