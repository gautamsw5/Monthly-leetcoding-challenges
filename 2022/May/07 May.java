class Solution {
    public boolean find132pattern(int[] arr) {
        TreeMap<Integer, Integer> left = new TreeMap<>(), right = new TreeMap<>();
        left.put(arr[0], 1);
        for(int i = 1; i < arr.length; i++) right.put(arr[i], right.getOrDefault(arr[i], 0) + 1); 
        for (int i = 1; i < arr.length; i++) {
            right.put(arr[i], right.get(arr[i]) - 1);
            if(right.get(arr[i]) == 0) right.remove(arr[i]);
            Integer two = right.lowerKey(arr[i]);
            if(two != null) {
                Integer one = left.lowerKey(two);
                if(one != null) return true;
            }
            left.put(arr[i], left.getOrDefault(arr[i], 0) + 1);
        }
        return false;
    }
}
