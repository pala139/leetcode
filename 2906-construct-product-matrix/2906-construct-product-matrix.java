class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int[][] p = new int[grid.length][grid[0].length];
        long prefix=1;
        int mod = 12345;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                p[i][j] = (int)prefix;
                prefix = (int)((prefix*grid[i][j])%(long)mod);
            }
        }
        long suffix = 1;
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                p[i][j] = (int)((p[i][j]*suffix)%(long)mod);
                suffix = (int)(suffix *grid[i][j]%(long)mod);
            }
        }
        return p;        
    }
}