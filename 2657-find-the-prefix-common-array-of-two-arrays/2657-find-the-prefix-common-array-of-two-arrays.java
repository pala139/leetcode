class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        int cnt = 0;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            int ele1 = A[i];
            int ele2 = B[i];
            map.put(ele1, map.getOrDefault(ele1, 0)+1);
            map.put(ele2, map.getOrDefault(ele2, 0)+1);
            if(map.get(ele1) == 2) cnt++;
            if(map.get(ele2) == 2 && ele1 != ele2) cnt++;
            res[i] = cnt;
        }
        return res;
    }
}