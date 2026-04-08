class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = (long)10e8+7;
        int n = nums.length;
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = (long)nums[i];
        }
        for(int[] q: queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            for(int i=l;i<=r;i+=k){
                arr[i] = (arr[i]*(long)v)%MOD;
            }
        }
        long res = 0;
        for(long ele: arr)
            res^=ele;
        return (int)res;
    }
}