class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = (long)10e8+7;
        int n = nums.length;
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = (long)nums[i];
        }
        for(int[] q: queries){
            for(int i=q[0];i<=q[1];i+=q[2]){
                arr[i] = (arr[i]*(long)q[3])%MOD;
            }
        }
        long res = 0;
        for(int i=0;i<n;i++)
            res ^=arr[i];
        return (int)res;
    }
}