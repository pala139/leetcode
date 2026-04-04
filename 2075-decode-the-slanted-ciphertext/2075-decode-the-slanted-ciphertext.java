class Solution {
    public String decodeCiphertext(String s, int r) {
        if (r == 1) return s; // single row — no transformation needed
        int n = s.length();
        
        int c = (int)Math.ceil((double) n / r); // compute number of columns
        char[][] mat = new char[r][c]; // allocate the r x c matrix
        char[] arr = s.toCharArray(); // convert for fast indexing
        int p = 0; // pointer into arr

        for (int i = 0; i < r; i++) { // fill matrix row by row
            for (int j = 0; j < c; j++) { // mirroring how encodedText was read
                mat[i][j] = arr[p++];
            }
        }

        StringBuilder res = new StringBuilder();
        for (int k = 0; k < c; k++) { // for each diagonal starting column
            int x = 0, y = k;
            while (x < r && y < c) { // walk diagonal down-right
                res.append(mat[x][y]); // collect characters in original order
                x++; y++;
            }
        }
        
        return res.toString().stripTrailing(); // remove padding spaces at the end
    }
}