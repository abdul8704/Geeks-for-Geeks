// Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

// Examples:
// Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
// Output: 4// Explanation: Four triplets that add up to -2 are:
// arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
// arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
// arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
// arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2

// Input: arr[] = [-2, 0, 1, 1, 5], target = 1
// Output: 0
// Explanation: There is no triplet whose sum is equal to 1. 

// Constraints:
// 3 ≤ arr.size() ≤ 104
// -105 ≤ arr[i], target ≤ 105

class Solution {
    public int countTriplets(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        int count=0;
        
        for(int i=0; i<arr.length-1; i++){
            left = i+1;
            right = arr.length-1;
            while(left < right){
                if(arr[left] + arr[right] + arr[i] == target){
                    int x=arr[left], y=arr[right];
                    int c1=0,c2 = 0;
                    
                    while(left <= right && arr[left] == x){
                        left++;
                        c1++;
                    }
                    while(left <= right && arr[right] == y){
                        right--;
                        c2++;
                    }
                    if(x == y){
                        count += (c1 * (c1 - 1))/2;
                    }
                    else{
                        count += (c1*c2);
                    }
                    
                    
                    
                    
                    
                }
                else if(arr[left] + arr[right] + arr[i] > target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return count;
    }
}