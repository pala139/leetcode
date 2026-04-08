class Solution {
    public int xorAfterQueries(int[] nums, int[][] q) {
        int mod = 1_000_000_007;
        for(int i=0;i<q.length;i++){
            int idx = q[i][0];
            while(idx<=q[i][1]){
                nums[idx] = (int)(((long)nums[idx] * q[i][3]) % mod);
                idx +=q[i][2];
            }
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
            res = res ^ nums[i];
        }
        return res;
    }
}