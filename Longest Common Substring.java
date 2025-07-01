// You are given two strings s1 and s2. Your task is to find the length of the longest common substring among the given strings.

// Examples:

// Input: s1 = "ABCDGH", s2 = "ACDGHR"
// Output: 4
// Explanation: The longest common substring is "CDGH" with a length of 4.
// Input: s1 = "abc", s2 = "acb"
// Output: 1
// Explanation: The longest common substrings are "a", "b", "c" all having length 1.
// Input: s1 = "YZ", s2 = "yz"
// Output: 0
// Constraints:
// 1 <= s1.size(), s2.size() <= 103
// Both strings may contain upper and lower case alphabets.



class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int R = s1.length(), C = s2.length(), res = 0;
        
        int dp[][] = new int[R+1][C+1];
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(s1.charAt(i) == s2.charAt(j))
                    dp[i+1][j+1] = dp[i][j] + 1;
                
                else
                    dp[i+1][j+1] = 0;
                
                res = Math.max(res, dp[i+1][j+1]);        
            }
        }
        
        return res;
        
        
    }
}