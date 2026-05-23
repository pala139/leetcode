class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            int mid = (left+right)>>1;
            if(nums[right]< nums[mid]){
                left = mid+1;
            }
            else
                right = mid;
        }
        return nums[left];
        
    }
}