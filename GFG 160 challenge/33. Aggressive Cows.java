// You are given an array with unique elements of stalls[], which denote the position of a stall.
// You are also given an integer k which denotes the number of aggressive cows. 
// Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

// Examples :
// Input: stalls[] = [1, 2, 4, 8, 9], k = 3
// Output: 3
// Explanation: The first cow can be placed at stalls[0], 
// the second cow can be placed at stalls[2] and 
// the third cow can be placed at stalls[3]. 
// The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.

// Input: stalls[] = [10, 1, 2, 7, 5], k = 3
// Output: 4
// Explanation: The first cow can be placed at stalls[0],
// the second cow can be placed at stalls[1] and
// the third cow can be placed at stalls[4].
// The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.

// Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
// Output: 1
// Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
// The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.

// Constraints:
// 2 <= stalls.size() <= 106
// 0 <= stalls[i] <= 108
// 2 <= k <= stalls.size(

import java.util.Arrays;

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        int N = stalls.length;
        Arrays.sort(stalls);
        
        int minDist = Integer.MAX_VALUE, maxDist = stalls[N-1] - stalls[0];
        for(int i=0; i<N-1; i++)
            minDist = Math.min(minDist, stalls[i+1] - stalls[i]);
        
        
        if(N == k)
            return minDist;
        
        int low = minDist, high = maxDist;

        while(low <= high){
            int mid = (low + high) / 2;
            
            if(isValid(stalls, k, mid))
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return high;
    }
    private static boolean isValid(int[] arr, int k, int minD){
        int lastCow = arr[0]; k--;
        for(int i=1; i<arr.length; i++){
            if(arr[i] - lastCow >= minD){
                lastCow = arr[i];
                k--; 
                if(k <= 0) return true;
            }
        }
        
        return k <= 0;
    }
}