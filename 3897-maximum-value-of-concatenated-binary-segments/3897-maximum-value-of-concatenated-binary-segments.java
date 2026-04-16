class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        List<String> segments = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder seg = new StringBuilder();
            for(int j=0;j<nums1[i];j++){
                seg.append(1);
            }
            for(int j=0;j<nums0[i];j++){
                seg.append(0);
            }
            segments.add(seg.toString());
        }
        Collections.sort(segments, (a, b)-> (b+a).compareTo(a+b));
        long res =0;
        int mod = 1_000_000_007;
        for(String seg: segments){
            for(char ch: seg.toCharArray()){
                res = (res*2+(ch-'0'))%mod;
            }
        }
        return (int)res;
    }
}