// Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.
// Note: A palindrome string is a sequence of characters that reads the same forward and backward.

// Examples:

// Input: s = "abc"
// Output: 2
// Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"

// Input: s = "aacecaaaa"
// Output: 2
// Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"

// Constraints:
// 1 <= s.size() <= 106

class Solution {
    static int[] constructLPS(String pat){
        int lps[] = new int[pat.length()];
        lps[0] = 0;
        
        int i = 1,length = 0;
        
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(length)){
                length++;
                lps[i] = length;
                i++;
            }
            else if(length != 0){
                length = lps[length - 1];
            }
            else{
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
    public static int minChar(String s) {
        StringBuilder str = new StringBuilder(s);
        s = s + "$" + str.reverse().toString();
        // System.out.println(s);
        
        int[] lps = constructLPS(s);
    
        return (str.length() - lps[lps.length - 1]);
    }
}