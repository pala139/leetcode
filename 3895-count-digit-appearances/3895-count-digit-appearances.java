class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int res = 0;
        for(int ele: nums){
            while(ele >0){
                if(ele%10 == digit) res++;
                ele/=10;
            }
        }
        return res;
    }
}