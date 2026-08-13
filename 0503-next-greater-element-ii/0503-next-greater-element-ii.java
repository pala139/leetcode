class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int N = arr.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);

        for(int i=0;i<N;i++){
            int curr = arr[i];

            for(int j=1;j<N;j++){
               if(arr[(i+j)%N] > curr) {
                res[i] = arr[(i+j)%N];
                break;
               }
            }
        }
        return res;
   
    }
}
