// Given an unsorted array arr[] of integers and an integer x, find the floor and ceiling of x in arr[].

// Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is smaller than smallest element of arr[].
// Ceil of x is the smallest element which is greater than or equal to x. Ceil of x doesn’t exist if x is greater than greatest element of arr[].

// Return an array of integers denoting the [floor, ceil]. Return -1 for floor or ceiling if the floor or ceiling is not present.

// Examples:
// Input: x = 7 , arr[] = [5, 6, 8, 9, 6, 5, 5, 6]
// Output: 6, 8
// Explanation: Floor of 7 is 6 and ceil of 7 is 8.

// Input: x = 10 , arr[] = [5, 6, 8, 8, 6, 5, 5, 6]
// Output: 8, -1
// Explanation: Floor of 10 is 8 but ceil of 10 is not possible.

// Expected Time Complexity: O(n)
// Expected Auxiliary Space: O(1)

// Constraints :
// 1 ≤ arr.size ≤ 105
// 1 ≤ arr[i], x ≤ 106

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int res[] = new int[2];
        int N = arr.length;
        
        res[0] = binarySearch(arr, N, x, 0);
        res[1] = binarySearch(arr, N, x, 1);
        
        return res;
    }
    private static int binarySearch(int arr[], int N, int target, int flag){ 
        int left = 0, right = N-1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(arr[mid] == target)
                return target;
            else if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        if(flag == 0)   
            return (right >= 0)? arr[right]: -1;
        else
            return (left < N) ? arr[left] : -1;
    }
}
