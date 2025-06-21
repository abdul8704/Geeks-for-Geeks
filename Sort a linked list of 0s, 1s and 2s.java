// Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

// Examples:
// Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
// Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
// Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.

// Input: head = 2 → 2 → 0 → 1
// Output: 0 → 1 → 2 → 2
// Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be 0 → 1 → 2 → 2.

// Constraints:
// 1 ≤ no. of nodes ≤ 106
// 0 ≤ node->data ≤ 2

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class Solution {
    static Node segregate(Node head) {
        int c0 = 0, c1 = 0, c2 = 0;
        
        Node ptr = head;
        
        while(ptr != null){
            if(ptr.data == 0) c0++;
            else if(ptr.data == 1) c1++;
            else c2++;
            
            ptr = ptr.next;
        }
        
        ptr = head;
        
        while(ptr != null){
            if(c0 > 0){
                ptr.data = 0;
                c0--;
            }
            else if(c1 > 0){
                ptr.data = 1;
                c1--;
            }
            else{
                ptr.data = 2;
                c2--;
            }
            
            ptr = ptr.next;
        }
        
        return head;
        
    }
    static Node segregate2(Node head) {
        Node c0 = new Node(0), c1 = new Node(0), c2 = new Node(0);
        Node p0 = c0, p1 = c1, p2 = c2;
        
        Node ptr = head;
        
        while(ptr != null){
            if(ptr.data == 0){
                c0.next = ptr;
                c0 = c0.next;
            } 
            else if(ptr.data == 1){
                c1.next = ptr;
                c1 = c1.next;
            }
            else{
                c2.next = ptr;
                c2 = c2.next;
            }
            
            ptr = ptr.next;
        }
    
        c0.next = (p1.next != null)? p1.next: p2.next;
        c1.next = (p2.next != null)? p2.next: null;
        c2.next = null;
        
        head = p0.next;
        
        return head;        
    }
}