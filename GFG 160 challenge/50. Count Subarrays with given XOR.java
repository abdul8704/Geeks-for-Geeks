// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

// Examples: 
// Input: arr[] = [4, 2, 2, 6, 4], k = 6
// Output: 4
// Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.

// Input: arr[] = [5, 6, 7, 8, 9], k = 5
// Output: 2
// Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.

// Input: arr[] = [1, 1, 1, 1], k = 0
// Output: 4
// Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].

// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ arr[i] ≤105
// 0 ≤ k ≤ 105

import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        long count = 0;
        long xor = 0;
        
        for(int i=0; i<arr.length; i++){
            xor ^= arr[i];            
            if(xor == k) 
                count++;
            
            if(map.containsKey(xor ^ k))    
                count += map.get(xor ^ k);
            
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }
        return count;
    }
}