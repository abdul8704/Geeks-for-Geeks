// Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
// An input string is valid if:

//          1. Open brackets must be closed by the same type of brackets.
//          2. Open brackets must be closed in the correct order.

// Examples :

// Input: s = "[{()}]"
// Output: true
// Explanation: All the brackets are well-formed.

// Input: s = "[()()]{}"
// Output: true
// Explanation: All the brackets are well-formed.

// Input: s = "([]"
// Output: False
// Explanation: The expression is not balanced as there is a missing ')' at the end.

// Input: s = "([{]})"
// Output: False
// Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.

// Constraints:
// 1 ≤ s.size() ≤ 106
// s[i] ∈ {'{', '}', '(', ')', '[', ']'}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    // Function to check if brackets are balanced or not.
    static boolean isParenthesisBalanced(String s) {
        Map<Character, Character> hash = new HashMap<>();
        hash.put(')', '(');
        hash.put('}', '{');
        hash.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty() || stack.peek() != hash.get(s.charAt(i))){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty();
    }
}

class Solution2 {                                       // space optimised solution...O(1)..if strings are mutable..
    static boolean checkMatch(char c1, char c2){
    if (c1 == '(' && c2 == ')') return true;
    if (c1 == '[' && c2 == ']') return true;
    if (c1 == '{' && c2 == '}') return true;
    return false;
}
    // Function to check if brackets are balanced or not.
    static boolean isParenthesisBalanced(String s) {


        char[] str = s.toCharArray();                       //convert to charArray to make it mutable
        
        int top = -1;
        
        for(int i=0; i<s.length(); i++){
            if(top < 0 || !checkMatch(str[top], str[i])){
                top++;
                str[top] = str[i];
            }
            else{
                top--;
            }
        }
        
        return top == -1;
    }
}
