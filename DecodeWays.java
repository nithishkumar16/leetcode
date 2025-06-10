class DecodeWays {
    public int numDecodings(String s) {
        HashMap<Integer,Integer> dp = new HashMap<>();
        return dfs(0,s,dp);
    }

    public int dfs(int i, String s, HashMap<Integer,Integer> dp) {

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        if(i==s.length()) return 1;

        if(s.charAt(i) == '0') return 0;

        int res = dfs(i+1,s,dp);
        if(i<s.length()-1 && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1) < '7')) {
            res += dfs(i+2,s,dp);
        }

        dp.put(i,res);

        return res;
    }
}