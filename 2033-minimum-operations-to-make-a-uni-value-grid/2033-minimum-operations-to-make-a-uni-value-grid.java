class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int size = arr.size();
        int middle = arr.get(size/2);
        int res = 0;
        for(int i=0;i<size;i++){
            if(arr.get(i)%x!=middle%x)
                return -1;
            res+=Math.abs(arr.get(i)-middle)/x;
        }
        return res;
    }
}