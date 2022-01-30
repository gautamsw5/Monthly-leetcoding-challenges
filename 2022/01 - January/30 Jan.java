class Solution {
public:
    void reverse(vector<int>& arr, int i, int j) {
        while(i < j) {
            int t = arr[i];
            arr[i++] = arr[j];
            arr[j--] = t;
        }
    }
    void rotate(vector<int>& arr, int k) {
        int n = arr.size();
        k = k % n;
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-k-1);
        reverse(arr, 0, n-1);
    }
};
