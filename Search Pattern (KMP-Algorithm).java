// Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
// Note: Return an empty list in case of no occurrences of pattern.

// Examples :

// Input: txt = "abcab", pat = "ab"
// Output: [0, 3]
// Explanation: The string "ab" occurs twice in txt, one starts at index 0 and the other at index 3. 

// Input: txt = "abesdu", pat = "edu"
// Output: []
// Explanation: There's no substring "edu" present in txt.

// Input: txt = "aabaacaadaabaaba", pat = "aaba"
// Output: [0, 9, 12]

// Constraints:
// 1 ≤ txt.size() ≤ 106
// 1 ≤ pat.size() < txt.size()
// Both the strings consist of lowercase English alphabets.

import java.util.ArrayList;

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = pat.length();
        int lps[] = new int[n];
        lps[0] = 0;

        //constrcting lps array        
        int i = 1, j = 0;
        while (i < n){
            if(pat.charAt(i) == pat.charAt(j)){
                j++;
                lps[i++] = j;
            }
            else if(j != 0){
                j = lps[j-1];
            }
            else{
                lps[i] = 0;
                i++;
            }
        }
        //searching
        i = 0; j = 0;
        while(i < txt.length()){
            if(pat.charAt(j) == txt.charAt(i)){
                i++;
                j++;
                if(j == n){
                    res.add(i-j);
                    j = lps[j-1];
                }
            }
            else if(j != 0){
                j = lps[j-1];
            }
            else{
                i++;
            }
        }
        return res;  
    }
}