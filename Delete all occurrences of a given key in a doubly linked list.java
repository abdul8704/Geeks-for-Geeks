// You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.
// Example1:
// Input: 
// 2<->2<->10<->8<->4<->2<->5<->2
// 2
// Output: 
// 10<->8<->4<->5
// Explanation: 
// All Occurences of 2 have been deleted.

// Example2:
// Input: 
// 9<->1<->3<->4<->5<->1<->8<->4
// 9
// Output: 
// 1<->3<->4<->5<->1<->8<->4
// Explanation: 
// All Occurences of 9 have been deleted.

// Your Task:
// Complete the function void deleteAllOccurOfX(struct Node** head_ref, int key), which takes the reference of the head pointer and an integer value key. Delete all occurrences of the key from the given DLL.
// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(1).

// Constraints:
// 1<=Number of Nodes<=105
// 0<=Node Value <=109

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        if(head == null)
            return head;
            
        Node ptr = head;
        
        while(ptr != null){
            if(ptr.data == x){
                if(ptr.prev == null){
                    head = ptr.next;
                    head.prev = null;
                }
                else if(ptr.next == null)
                    ptr.prev.next = null;
                else{
                    ptr.prev.next = ptr.next;
                    ptr.next.prev = ptr.prev;
                }    
            }
            
            ptr = ptr.next;
        }
        return head;
    }
}