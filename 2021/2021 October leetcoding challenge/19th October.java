class Solution {
    public int[] nextGreaterElement(int[] arr, int[] brr) {
        int[] res = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < brr.length; i++) {
            map.put(brr[i], i);
        }
        for(int i = 0; i < arr.length; i++) {
            res[i] = -1;
            for(int j = map.get(arr[i]) + 1; j < brr.length; j++) {
                if(brr[j] > arr[i]) {
                    res[i] = brr[j];
                    break;
                }
            }
        }
        return res;
    }
}
