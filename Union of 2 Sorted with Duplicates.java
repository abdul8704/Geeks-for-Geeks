// Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return the elements in the union of the two arrays in sorted order.

// Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.
// Examples:

// Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
// Output: 1 2 3 4 5 6 7
// Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.

// Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
// Output: 1 2 3 4 5
// Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.

// Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
// Output: 1 2
// Explanation: Distinct elements including both the arrays are: 1 2.

// Constraints:
// 1  <=  a.size(), b.size()  <=  105
// -109  <=  a[i] , b[i]  <=  109

import java.util.ArrayList;

class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int i=0, j=0;
        
        while(i<a.length && j<b.length){
            while(i+1 < a.length && a[i] == a[i+1]){
                i++;
            }
            while(j+1 < b.length && b[j] == b[j+1]){
                j++;
            }
            if(a[i] == b[j]){
                res.add(a[i]);
                i++;
                j++;
            }
            else if(a[i] < b[j]){
                res.add(a[i]);
                i++;
            }
            else{
                res.add(b[j]);
                j++;
            }
        }
        while(i < a.length){
            while(i+1 < a.length && a[i] == a[i+1]){
                i++;
            } 
            res.add(a[i]);
            i++;
        }
        while(j < b.length){
            while(j+1 < b.length && b[j] == b[j+1]){
                j++;
            }
            res.add(b[j]);
            j++;
        }
        return res;
    }
}