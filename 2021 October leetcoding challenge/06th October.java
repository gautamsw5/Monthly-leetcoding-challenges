class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        int[] freq = new int[arr.length];
        List<Integer> ans = new ArrayList<>();
        for(int i : arr) {
            freq[i-1]++;
            if(freq[i-1] == 2) ans.add(i);
        }
        return ans;
    }
}
