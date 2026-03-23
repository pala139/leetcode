class Pair {
    long first;   // max product
    long second;  // min product
    Pair(long f, long s) {
        first = f;
        second = s;
    }
}

class Solution {
    private static final int MOD = 1_000_000_007;

    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // dp[i][j] = {max product to reach (i,j), min product to reach (i,j)}
        Pair[][] dp = new Pair[rows][cols];

        // Initialize starting point
        dp[0][0] = new Pair(grid[0][0], grid[0][0]);

        // Fill first row
        for (int j = 1; j < cols; j++) {
            long val = grid[0][j];
            long prevMax = dp[0][j-1].first;
            long prevMin = dp[0][j-1].second;

            long newMax = prevMax * val;
            long newMin = prevMin * val;

            // since only one way → max and min are the same in this case
            dp[0][j] = new Pair(newMax, newMin);
        }

        // Fill first column
        for (int i = 1; i < rows; i++) {
            long val = grid[i][0];
            long prevMax = dp[i-1][0].first;
            long prevMin = dp[i-1][0].second;

            long newMax = prevMax * val;
            long newMin = prevMin * val;

            dp[i][0] = new Pair(newMax, newMin);
        }

        // Fill rest of the table
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                long val = grid[i][j];

                // candidates from up
                long upMax   = dp[i-1][j].first;
                long upMin   = dp[i-1][j].second;

                // candidates from left
                long leftMax = dp[i][j-1].first;
                long leftMin = dp[i][j-1].second;

                long cand1 = upMax   * val;
                long cand2 = upMin   * val;
                long cand3 = leftMax * val;
                long cand4 = leftMin * val;

                long overallMax = Math.max(Math.max(cand1, cand2), Math.max(cand3, cand4));
                long overallMin = Math.min(Math.min(cand1, cand2), Math.min(cand3, cand4));

                dp[i][j] = new Pair(overallMax, overallMin);
            }
        }

        long finalMax = Math.max(dp[rows-1][cols-1].first, dp[rows-1][cols-1].second);

        if (finalMax < 0) {
            return -1;
        }

        return (int) (finalMax % MOD);
    }
}