// You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 
// Note: The head represents the first element of the given array.

// Examples :
// Input: LinkedList: 4->5->6
// Output: 457
// Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 

// Input: LinkedList: 1->2->3
// Output: 124 
// Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 

// Expected Time Complexity: O(n)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 <= len(list) <= 105
// 0 <= list[i] <= 9

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    private static Node reverse(Node head){
        if(head == null || head.next == null)
            return head;
        Node temp = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return temp;    
    }
    public Node addOne(Node head) {
        Node newHead = reverse(head);
        Node ptr = newHead;
        int carry = 1;

        while(carry != 0 && ptr != null){
            int x = ptr.data + carry;
            ptr.data = x % 10;
            carry = x / 10;
            if(ptr.next == null) break;
            ptr = ptr.next;
        }
        if(carry != 0){
            Node last = new Node(carry);
            ptr.next = last;
        }
        return reverse(newHead);
    } 
}
