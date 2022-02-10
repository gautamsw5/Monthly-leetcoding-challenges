class Solution
{
    public int subarraySum(int[] arr, int k)
    {
        int ans = 0, sum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for(int i : arr) {
            ans += freq.getOrDefault(sum-k+i, 0);
            sum += i;
            freq.put(sum, freq.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}
