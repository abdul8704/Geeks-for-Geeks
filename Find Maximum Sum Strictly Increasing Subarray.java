// Given an array of positive integers. Find the maximum sum of strictly increasing subarrays.
Find Maximum Sum Strictly Increasing Subarray
// Example 1:

// Input : 
// arr[] = {1, 2, 3, 2, 5, 1, 7}
// Output : 
// 8
// Explanation :
// Some Strictly increasing subarrays are -
// {1, 2, 3} sum = 6,
// {2, 5} sum = 7,
// {1, 7} sum = 8,
// maximum sum = 8
 
// Example 2:

// Input:
// arr[] = {1, 2, 2, 4}
// Output:
// 6

// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function maxsum_SIS() which takes the array arr[] and its size N as inputs and returns the required result.

// Expected Time Complexty: O(N)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 ≤ N ≤ 105

class Solution { 

	static int maxsum_SIS(int arr[], int n) 
	{ 
	    int sum=arr[0], maxSum=arr[0];
	    
	    for(int i=0; i<arr.length-1; i++){
	        if(arr[i] < arr[i + 1]){
	            sum += arr[i+1];
	        }
	        else{
	            maxSum = Math.max(maxSum, sum);
	            sum = arr[i+1];
	        }
	    }
	    return Math.max(maxSum, sum);
	}
} 