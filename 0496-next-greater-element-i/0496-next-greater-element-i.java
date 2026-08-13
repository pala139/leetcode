class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums2.length];
        Arrays.fill(res, -1);
        for(int i=0;i<nums2.length;i++){
            int curr = nums2[i];
            while(!stack.isEmpty() && curr > nums2[stack.peek()]){
                int prev = stack.pop();
                res[prev] = curr;
            }
            stack.push(i);
        }


        for(int i=0;i<nums1.length;i++){
            int curr = nums1[i];
            for(int j=0;j<nums2.length;j++){
                if(curr == nums2[j]){
                    nums1[i] = res[j];
                    break;
                }
            }
        }
        return nums1;
    }
}