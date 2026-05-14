class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] != i+1)
                return false;
        }
        int n = nums.length;
        if(n > 1 && nums[n-1] == nums[n-2]){
            return true;
        }
        return false;

        
    }
}