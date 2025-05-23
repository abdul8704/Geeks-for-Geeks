// Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.

// Examples:
// Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
// Output:
// 2 2 3 4
// 7 10
// Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10

// Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
// Output:
// 1 2 3 5 8 9
// 10 13 15 20
// Explanation: After merging two sorted arrays we get 1 2 3 5 8 9 10 13 15 20.

// Input: a[] = [0, 1], b[] = [2, 3]
// Output:
// 0 1
// 2 3
// Explanation: After merging two sorted arrays we get 0 1 2 3.

// Constraints:
// 1 <= a.size(), b.size() <= 105
// 0 <= a[i], b[i] <= 107

import java.util.Arrays;

class Solution {
    public void mergeArrays(int a[], int b[]) {
        int N = a.length, M = b.length;
        int left = N-1, right = 0;
        
        while(left >= 0 && right < M){
            if(a[left] > b[right]){
                int temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--; right++;
            }
            else
                right++;
        }
        
        Arrays.sort(a); Arrays.sort(b);
        return;
    }
}
class Solution2 {
    // gap method
    public void mergeArrays(int a[], int b[]) {
        int N = a.length, M = b.length;
        int gap = (int) Math.ceil((N+M) / 2.0);
        
        while(gap > 0){
            int left = 0, right = left + gap;
            while (right < N+M){
                if(left < N && right >= N){
                    if(a[left] > b[right - N])
                        swap(a, b, left, right-N);
                }
                else if(right < N){
                    if(a[left] > a[right]){
                        swap(a, a, left, right);
                    }
                }
                else{
                    if(b[left - N] > b[right-N]){
                        swap(b, b, left-N, right-N);
                    }
                }
                left++; right++;
            }
            if(gap == 1) break;
            gap = (int) Math.ceil(gap/2.0);
        }
    }
    private static void swap(int a[], int b[], int i, int j){
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
        return;
    }
}    