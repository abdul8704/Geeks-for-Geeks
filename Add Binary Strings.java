// Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
// Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

// Input: s1 = "1101", s2 = "111"
// Output: 10100
// Explanation:
//  1101
// + 111
// 10100

// Input: s1 = "00100", s2 = "010"
// Output: 110
// Explanation: 
//   100
// +  10
//   110

// Constraints:
// 1 ≤s1.size(), s2.size()≤ 106

class Solution {
    public String addBinary(String s1, String s2) {
        if(s2.length() > s1.length()){
            addBinary(s2, s1);
        }
        int i = 0, j = 0;
        
        while(i < s1.length() && s1.charAt(i) == '0'){
            i++;
        }
            
        while(j < s2.length() && s2.charAt(j) == '0'){
            j++;
        }
            
        
        s1 = s1.substring(i);
        s2 = s2.substring(j);
        // System.out.println(s1+" "+s2);
        i = s1.length() - 1;
        j = s2.length() - 1;
        
        int carry = 0, sum = 0, bit1 = 0, bit2 = 0;
        StringBuilder res = new StringBuilder();
        
        while(i >= 0 || j >= 0 || carry !=0){
            
            bit1 = (i >= 0)?s1.charAt(i) - '0' : 0;
            bit2 = (j >= 0)?s2.charAt(j) - '0' : 0;
            
            sum = bit1 + bit2 + carry;
            carry =sum / 2;
            res.insert(0 ,sum%2);
            
            i--;
            j--;
        }
        
        // res.insert(0, s1.substring(0, i+1));
        return res.toString();
    }
}   