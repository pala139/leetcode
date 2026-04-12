class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] res = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res[j]+=matrix[i][j];
            }
        }
        return res;
    }
}