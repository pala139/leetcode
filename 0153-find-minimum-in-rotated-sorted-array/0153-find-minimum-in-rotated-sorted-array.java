class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int ele : nums) {
            if (res > ele) {
                res = ele;
            }
        }
        return res;
    }
}
