// You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
// Note: pairs should have elements of distinct indexes. 

// Examples :

// Input: arr[] = [-1, 1, 5, 5, 7], target = 6
// Output: 3
// Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.

// Input: arr[] = [1, 1, 1, 1], target = 2
// Output: 6
// Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.

// Input: arr[] = [-1, 10, 10, 12, 15], target = 125
// Output: 0
// Explanation: There is no such pair which sums up to 125.

// Constraints:
// -105 <= target <=105
//  2 <= arr.size() <= 105
// -105 <= arr[i] <= 105

class Solution {
    int countPairs(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        int res = 0;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(sum > target){
                right--;
            }
            else if(sum < target){
                left++;
            }
            else{
                int x = arr[left], y = arr[right];
                int x_count = 0, y_count = 0;
                
                while(left <= right && arr[left] == x){
                    x_count++;
                    left++;
                }
                while(left <= right && arr[right] == y){
                    right--;
                    y_count++;
                }
                
                if(x == y){
                    res += ((x_count * (x_count-1))/2);
                }
                else{
                    res += (x_count * y_count);
                }
            }
        }
        return res;
        
    }
}
