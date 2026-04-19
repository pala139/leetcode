class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int resmin = Integer.MAX_VALUE;
        int resind = Integer.MAX_VALUE;
        int n = nums.length;
        for(int ind =0;ind<n;ind++){
            int max = nums[0];
            for(int i =1;i<ind;i++){
                max = Math.max(max, nums[i]);
            }
            int min = nums[ind];
            for(int j=ind+1;j<n;j++){
                min = Math.min(min, nums[j]);
            }
            if(max-min<=k){
                return ind;
            }
        }
        return resind!=Integer.MAX_VALUE?resind :-1;
        
    }
}