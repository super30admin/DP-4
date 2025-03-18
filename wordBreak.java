// Problem1:(https://leetcode.com/problems/maximal-square/)

// Time Complexity : O(lxl) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take boolean dp array of length string length + 1. Fill dp[0] with true because with the characters before 0th index can form a 
 * valid string. Now traverse the length of the dp and also string till i of dp at the same time and if you find true anywhere in dp[i] 
 * check for substring from j to i is present in set, if yes set dp[i] to true. Finally return dp[dp.length-1].
 */
// 1 brute force
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }
    private boolean helper(String s, HashSet<String> set){
        if(s.length()==0) return true;
        
        for(int i = 0; i< s.length();i++){
            String sb = s.substring(0, i+1);
            if(set.contains(sb) && helper(s.substring(i+1), set)){
                return true;
            }
        }
        return false;
    }
}
// 2 dp top-down memorization
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashSet<String> memoSet = new HashSet<>();
        return helper(s, set, memoSet);
    }
    private boolean helper(String s, HashSet<String> set, HashSet<String> memoSet){
        if(s.length()==0) return true;
        if(memoSet.contains(s)) return false;
        for(int i = 0; i< s.length();i++){
            String sb = s.substring(0, i+1);
            if(set.contains(sb)){
                String rest = s.substring(i+1);
                boolean interResult = helper(rest, set, memoSet);
                if(interResult) return true;
                else{
                    memoSet.add(rest);
                }
            }
        }
        return false;
    }
}
// 3 dp bottom - up
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] == true){
                    String sb = s.substring(j, i);
                    if(set.contains(sb)){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[dp.length-1];
    }
}