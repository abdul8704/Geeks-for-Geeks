// Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

// Examples:
// Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
// Output: true 
// Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

// Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
// Output: false
// Explanation: There is no subset with target sum 30.

// Input: arr[] = [1, 2, 3], sum = 6
// Output: true
// Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.

// Constraints:
// 1 <= arr.size() <= 200
// 1<= arr[i] <= 200
// 1<= sum <= 104

/* 
 *  1=> RECURSIVE(DFS)
 * 2 => MEMOIZATION
 * 3 => DYNAMIC PROGRAMMING
 */
class DFS_Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int N = arr.length;
        
        if(dfs(arr, N-1, sum))
            return true;
            
        return false;        
    }
    private static boolean dfs(int[] arr, int ptr, int tar){
        if(tar == 0)
            return true;
        if(ptr == 0)
            return arr[ptr] == tar;
        
        boolean notTake = dfs(arr, ptr-1, tar);
        boolean take = false;
        
        if(arr[ptr] <= tar)
            take = dfs(arr, ptr-1, tar-arr[ptr]);
        
        return take || notTake;        
    }
}

class MEMOIZATION_Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int N = arr.length;
        Boolean[][] memo = new Boolean[N][sum+1];
        
        if(dfs(arr, N-1, sum, memo))
            return true;
            
        return false;        
    }
    private static boolean dfs(int[] arr, int ptr, int tar, Boolean[][] memo){
        if(tar == 0)
            return true;
        if(ptr == 0)
            return arr[ptr] == tar;
        
        if(memo[ptr][tar] != null)
            return memo[ptr][tar];
        
        boolean notTake = dfs(arr, ptr-1, tar, memo);
        boolean take = false;
        
        if(arr[ptr] <= tar)
            take = dfs(arr, ptr-1, tar-arr[ptr], memo);
        
        memo[ptr][tar] = take || notTake;
        return take || notTake;        
    }
}

class DP_Solution{
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int N = arr.length;
        boolean[][] dp = new boolean[N][sum+1];
        
        for(int i=0; i<N; i++)
            dp[i][0] = true;
            
        if (arr[0] <= sum) dp[0][arr[0]] = true;
        
        for(int i=1; i<N; i++)
            for(int tar=1; tar <= sum; tar++)
                dp[i][tar] = dp[i-1][tar] || 
                            ( 
                                (arr[i] <= tar) ? dp[i-1][tar - arr[i]]: false
                            );
            
        
        
        return dp[N-1][sum];
    }
}