class NumArray {

    int[] sum;
    public NumArray(int[] arr) {
        sum = arr;
        for(int i = 1; i < arr.length; i++)
            sum[i] += sum[i-1];
    }
    
    public int sumRange(int left, int right) {
        if(left > 0)
            return sum[right] - sum[left-1];
        return sum[right];
    }
}
