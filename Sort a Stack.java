// Given a stack, the task is to sort it such that the top of the stack has the greatest element.

// Example 1:
// Input:
// Stack: 3 2 1
// Output: 3 2 1

// Example 2:
// Input:
// Stack: 11 2 32 3 41
// Output: 41 32 11 3 2
// Your Task: 
// You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

// Expected Time Complexity: O(N*N)
// Expected Auxilliary Space: O(N) recursive.

// Constraints:
// 1<=N<=100

import java.util.Stack;

class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        return helper(s);
    }
    private static Stack<Integer> helper(Stack<Integer> stk){
        Stack<Integer> temp = new Stack<>();
        while(!stk.isEmpty())
            temp.push(stk.pop());
        
        return sortStack(stk, temp);        
    }
    private static Stack<Integer> sortStack(Stack<Integer> stk, Stack<Integer> temp){
        if(temp.isEmpty())
            return stk;
        if(stk.isEmpty() || stk.peek() < temp.peek())
            stk.push(temp.pop());
        else{
            int top = temp.pop();
            while(!stk.isEmpty() && top < stk.peek())
                temp.push(stk.pop());
            stk.push(top);
        }    
        
        return sortStack(stk, temp);
    }
}