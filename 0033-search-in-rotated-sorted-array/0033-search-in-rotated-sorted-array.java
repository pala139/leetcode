class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int mid=-1;
        int prev=0;
        int next=0;
        int n=nums.length;
        while(start<=end)   {
            mid=end+(start-end)/2;
            prev=(mid+n-1)%n;
            next=(mid+1)%n;
            if(nums[mid]<=nums[prev] && nums[mid]<=nums[next])
                return mid;
            else if(nums[mid]>nums[n-1])
                start=mid+1;
            else 
                end=mid-1;
        }
        return mid;
    }    
    public static int search(int[] nums,int start,int end,int ele)  {
        if(start>end) return -1;
        int mid;
        while(start<=end)   {
            mid=end+(start-end)/2;
            if(nums[mid]==ele)  {
                 return mid;
            }
            else if(ele>nums[mid])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
    
    
    public int search(int[] nums, int target) {
        int pivot=findMin(nums);
        int left=search(nums,0,pivot-1,target);
        int right=search(nums,pivot,nums.length-1,target);
        if(left!=-1)    return left;
        else if(right!=-1)  return right;
        else    return -1;
    }
}