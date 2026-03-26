class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        double sum =0;
        for(int[] row: grid){
            for(int x: row){
                sum+=x;
            }
        }
        double rowSum =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                rowSum += grid[i][j];
            }
            if(rowSum == sum/2) return true;
        }
        double columnSum =0;
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                columnSum+=grid[i][j];
            }
            if(columnSum == sum/2) return true;
        }
        return false;
    }
}