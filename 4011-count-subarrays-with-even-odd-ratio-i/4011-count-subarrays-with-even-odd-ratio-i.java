class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        // x/y <=a/b
        // x*b <=a*y => x*b - a*y <=0
        int x = 0;
        int y = 0;
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n;i++){
            x = 0;
            y = 0;
            for(int j=i;j<n;j++){
                int anony = nums[j]%2 == 0 ? x++ : y++;
                if((long)x*b<=a*y ) res++;
            }
        }
        return res;
    }
}