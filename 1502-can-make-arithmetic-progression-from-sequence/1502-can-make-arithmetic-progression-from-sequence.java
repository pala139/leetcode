class Solution {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        
        for(int i = 1; i < n-1; i++){
            if(arr[i] - arr[i-1] != arr[i+1] - arr[i]){
                return false;
            }
        }
        return true;
    }
}