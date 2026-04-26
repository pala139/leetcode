import java.util.*;

class Solution {

    void dfs(int u, List<List<Integer>> adj, int[] vis) {
        if (vis[u] == 1) return;
        vis[u] = 1;

        for (int v : adj.get(u)) {
            if (vis[v] == 0) {
                dfs(v, adj, vis);
            }
        }
    }

    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] vis = new int[n];
        int ans = 0;

        // Iterate over all subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            Arrays.fill(vis, -1);
            List<Integer> subset = new ArrayList<>();
            int sum = 0;

            // Build subset
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    subset.add(j);
                    vis[j] = 0; // mark as present but not visited
                    sum += nums[j];
                }
            }

            // Run DFS from first node of subset
            dfs(subset.get(subset.size()-1), adj, vis);

            // Count visited nodes
            int count = 0;
            for (int v : vis) {
                if (v == 1) count++;
            }

            // Check connectivity + even sum
            if (count == subset.size() && sum % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }
}