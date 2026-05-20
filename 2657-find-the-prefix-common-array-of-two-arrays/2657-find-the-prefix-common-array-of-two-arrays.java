class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int cnt = 0;
        int[] map = new int[len+1];
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            int ele1 = A[i];
            int ele2 = B[i];
            map[ele1]++;
            map[ele2]++;
            if(map[ele1] == 2) cnt++;
            if(map[ele2] == 2 && ele1 != ele2) cnt++;
            res[i] = cnt;
        }
        return res;
    }
}