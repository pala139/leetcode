class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=0;i<k/2;i++){
            for(int j=0;j<k;j++){
                int ele1 = grid[x+i][y+j];
                int ele2 = grid[x+k-i-1][y+j];
                grid[x+i][y+j] = ele2;
                grid[x+k-i-1][y+j] = ele1;

            }
        }
        return grid;
    }
}