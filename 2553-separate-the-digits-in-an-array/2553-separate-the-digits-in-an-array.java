class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> sep = new LinkedList<>();
        for(int i=nums.length-1;i>=0;i--){
            int ele = nums[i];
            while(ele > 0){
                sep.add(ele%10);
                ele/=10;
            }
        }
        int[] convertedRes = new int[sep.size()];
        int len = convertedRes.length;
        for(int i=0;i<len;i++){
            convertedRes[i] = sep.get(len-i-1);
        }
        return convertedRes;
    }
}