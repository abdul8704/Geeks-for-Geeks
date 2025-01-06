// You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

// Note: The characters in the strings are in lowercase.

// Examples :

// Input: s1 = "abcd", s2 = "cdab"
// Output: true
// Explanation: After 2 right rotations, s1 will become equal to s2.

// Input: s1 = "aab", s2 = "aba"
// Output: true
// Explanation: After 1 left rotation, s1 will become equal to s2.

// Input: s1 = "abcd", s2 = "acbd"
// Output: false
// Explanation: Strings are not rotations of each other.

// Constraints:
// 1 <= s1.size(), s2.size() <= 105

class Solution {
    // Function to check if two strings are rotations of each other or not.
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
    public static boolean areRotations(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        if(s1.length() != s2.length())
            return false;
            
        String str = s1 + s1;
        
        int[] lps = constructLPS(s2);
        
        int i = 0, j = 0;
        while(i < str.length()){
            if(str.charAt(i) == s2.charAt(j)){
                i++;
                j++;
                
                if(j == s2.length()){
                    return true;
                }
            }
            else if(j != 0){
                j = lps[j-1];
            }
            else{
                i++;
            }
        }
        return false;
        
    }
}