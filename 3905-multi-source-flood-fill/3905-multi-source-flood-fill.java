class Solution {
    public int[][] colorGrid(int m, int n, int[][] sources) {
        Queue<int[]> q = new LinkedList<>();
        int[][] grid = new int[m][n];
        for (int[] s : sources) {
            int sm = s[0];
            int sn = s[1];
            int col = s[2];
            grid[sm][sn] = col;
            q.offer(new int[] { sm, sn, col });
        }
        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        while (!q.isEmpty()) {
            int size = q.size();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                int[] tempq = q.poll();
                for (int[] d : dir) {
                    int nm = tempq[0] + d[0];
                    int nn = tempq[1] + d[1];
                    int ncol = tempq[2];
                    int key = nm * n + nn;
                    if (nm >= m || nn >= n || nm < 0 || nn < 0)
                        continue;
                    if (grid[nm][nn] == 0)
                        map.put(key, Math.max(map.getOrDefault(key, 0), ncol));
                }
            }
            for (int key : map.keySet()) {
                int nm = key / n;
                int nn = key % n;
                grid[nm][nn] = map.get(key);
                q.offer(new int[] { nm, nn, map.get(key) });
            }
        }
        return grid;
    }
}