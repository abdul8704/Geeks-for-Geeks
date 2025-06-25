// Given a linked list containing n head nodes where every node in the linked list contains two pointers:
// (i) next points to the next node in the list.
// (ii) bottom pointer to a sub-linked list where the current node is the head.
// Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data.
// Your task is to flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.

// Note:
// 1. ↓ represents the bottom pointer and -> represents the next pointer.
// 2. The flattened list will be printed using the bottom pointer instead of the next pointer.

// Examples:
// Input:
// Output: 5-> 7-> 8-> 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
// Explanation: 
// Bottom pointer of 5 is pointing to 7.
// Bottom pointer of 7 is pointing to 8.
// Bottom pointer of 8 is pointing to 10 and so on.

// Input: 
// Output: 5-> 7-> 8-> 10-> 19-> 22-> 28-> 30-> 50
// Explanation:
// Bottom pointer of 5 is pointing to 7.
// Bottom pointer of 7 is pointing to 8.
// Bottom pointer of 8 is pointing to 10 and so on.
// Constraints:
// 0 <= n <= 100
// 1 <= number of nodes in sub-linked list(mi) <= 50
// 1 <= node->data <= 104

class Solution {
    Node flatten(Node head) {
        if(head == null || head.next == null)
            return head;
        Node temp = flatten(head.next);
        temp = mergeTwoList(head, temp);
        return temp;
        
    }
    Node mergeTwoList(Node list1, Node list2){
        Node ret = new Node(-1);
        Node ptr = ret;
        
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                ptr.bottom = new Node(list1.data);
                list1 = list1.bottom;
            }
            else{
                ptr.bottom = new Node(list2.data);
                list2 = list2.bottom;
            }
            ptr = ptr.bottom;
        }
        
        if(list1 != null){
            ptr.bottom = list1;
        }
        
        if(list2 != null){
            ptr.bottom = list2;
        }
        
        return ret.bottom;
    }
}