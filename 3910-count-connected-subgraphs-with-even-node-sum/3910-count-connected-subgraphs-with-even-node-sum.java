class Solution {
    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        if (vis[node] == 1)
            return;
        vis[node] = 1;
        for (int v : adj.get(node)) {
            if (vis[v] == 0) {
                dfs(v, vis, adj);
            }

        }
    }

    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        for (int mask = 1; mask < 1 << n; mask++) {
            List<Integer> subset = new LinkedList<Integer>();
            int sum = 0;
            int[] vis = new int[n];
            Arrays.fill(vis, -1);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(i);
                    sum += nums[i];
                    vis[i] = 0;
                }
            }
            dfs(subset.get(0), vis, adj);

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (vis[i] == 1)
                    cnt++;
            }
            if (cnt == subset.size() && sum % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}