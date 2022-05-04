class Solution
{
    public int maxOperations(int[] arr, int k)
    {
        int c=0;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i:arr)
        {
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        if(k%2==0 && freq.containsKey(k/2))
        {
            c=c+freq.get(k/2)/2;
            freq.put(k/2,0);
        }
        for(int i:freq.keySet())
        {
            if(freq.containsKey(k-i))
            {
                int x=Math.min(freq.get(i),freq.get(k-i));
                c=c+x;
                freq.put(i,freq.get(i)-x);
                freq.put(k-i,freq.get(k-i)-x);
            }
        }
        return c;
    }
}
