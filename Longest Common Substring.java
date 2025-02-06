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
    private static boolean check(int i, int j, int R, int C){
        return (i >= 0 && i < R && j >= 0 && j < C); 
    }
    public int longestCommonSubstr(String s1, String s2) {
        int R = s1.length();
        int C = s2.length();
        
        int dp[][] = new int[R][C];
        int max = 0;

        for(int row=0; row< R; row++){
            for(int col=0; col < C; col++){
                if(s1.charAt(row) == s2.charAt(col)){
                    if(check(row-1, col-1, R, C)){
                        dp[row][col] = dp[row-1][col-1] + 1;
                        
                    }else{
                        dp[row][col] = 1;
                    }
                    max = Math.max(max, dp[row][col]);
                }
            }
        }
        return max;
    }
}