// You are given a stack St. You have to reverse the stack using recursion.

// Example 1:
// Input:
// St = {3,2,1,7,6}
// Output:
// {6,7,1,2,3}
// Explanation:
// Input stack after reversing will look like the stack in the output.

// Example 2:
// Input:
// St = {4,3,9,6}
// Output:
// {6,9,3,4}
// Explanation:
// Input stack after reversing will look like the stack in the output.
// Your Task:

// You don't need to read input or print anything. Your task is to complete the function Reverse() which takes the stack St as input and reverses the given stack.

// Expected Time Complexity: O(N2)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 <= size of the stack <= 104
// -109 <= Each element of the stack <= 109
// Sum of N over all test cases doesn't exceeds 106
// Array may contain duplicate elements. 
import java.util.Stack;

class Solution {
    static void reverse(Stack<Integer> s) {
        if(!s.isEmpty()){
            int top = s.pop();
            reverse(s);
            
            insertLast(s, top);
        }
    }
    private static void insertLast(Stack<Integer> s, int val){
        if(s.isEmpty())
            s.push(val);
        else{
            int top = s.pop();
            insertLast(s, val);
            s.push(top);
        }        
    }
}