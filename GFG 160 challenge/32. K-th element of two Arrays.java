// Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

// Examples :
// Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
// Output: 6
// Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.

// Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
// Output: 256
// Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.

// Constraints:
// 1 <= a.size(), b.size() <= 106
// 1 <= k <= a.size() + b.size()
// 0 <= a[i], b[i] < 108

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length, m = b.length, total = n+m;
        
        if( n > m ) return kthElement(b, a, k);
        
        int left = Math.max(0, k-m), right = Math.min(k, n);
        
        while(left <= right){
            int mid1 = (left + right) / 2;
            int mid2 = Math.abs(k-mid1);
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            
            if(mid1-1 >= 0) l1 = a[mid1-1];
            if(mid2 - 1 >=0 ) l2 = b[mid2-1];
            if(mid1 < n) r1 = a[mid1];
            if(mid2 < m) r2 = b[mid2];
            
            if(l1 > r2)
                right =  mid1 - 1;
            else if(l2 > r1)
                left = mid1 + 1;
            else
                return Math.max(l1, l2);
        }
        return -1;
    }
}