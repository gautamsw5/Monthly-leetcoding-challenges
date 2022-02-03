class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> f1 = new HashMap<>(), f2 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                f1.put(nums1[i]+nums2[j], f1.getOrDefault(nums1[i]+nums2[j], 0) + 1);
                f2.put(nums3[i]+nums4[j], f2.getOrDefault(nums3[i]+nums4[j], 0) + 1);
            }
        }
        int ans = 0;
        for(int a : f1.keySet()) {
            ans += f1.get(a)*f2.getOrDefault(-a, 0);
        }
        return ans;
    }
}
