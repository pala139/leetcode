class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> eleInA = new HashSet<>();
        Set<Integer> eleInB = new HashSet<>();
        int len = A.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            eleInA.add(A[i]);
            eleInB.add(B[i]);
            int common = 0;
            for(int ele: eleInA){
                if(eleInB.contains(ele)){
                    ++common;
                }
            }
            res[i] = common;
        }
        return res;
        
    }
}