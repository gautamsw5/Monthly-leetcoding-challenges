class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int[][] arr = new int[startTime.length][3];
        
        for(int i = 0; i < startTime.length; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        
        Arrays.sort(arr, (a,b)->(a[1]-b[1]));

        // System.out.println("arr: "+Arrays.deepToString(arr));
        
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); int ans = 0;
        map.put(0, 0);
        for(int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, Math.max(map.getOrDefault(arr[i][1], 0), arr[i][2] + map.get(map.lowerKey(arr[i][0]+1))));
            map.put(arr[i][1], ans);
        }
        
        return ans;
    }
}
