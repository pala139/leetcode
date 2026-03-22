class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n= mat.length;
        for(int ind=0;ind<4;ind++){
            // do 4 rotations
            int[][] temp = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    temp[i][j] = mat[n-1-j][i];
                }
            }
            mat = temp;
            if(isEqual(mat, target)){
                return true;
            }
        }

        return false;
    }
    private boolean isEqual(int[][] mat1, int[][]mat2){
        int n = mat1.length;
        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat1.length;j++){
                if(mat1[i][j] != mat2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}