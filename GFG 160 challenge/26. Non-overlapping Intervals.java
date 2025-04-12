// Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ].
// Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Examples:
// Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
// Output: 1
// Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.

// Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
// Output: 2
// Explanation: You need to remove two [1, 3] to make the rest of the intervals non-overlapping.

// Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
// Output: 0
// Explanation: All ranges are already non overlapping.

// Constraints:
// 1 ≤ intervals.size() ≤  105
// 0 ≤ starti < endi <=5*104

import java.util.Arrays;

class Solution {
    static int minRemoval(int intervals[][]) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0])?
        Integer.compare(a[1], b[1]): Integer.compare(a[0], b[0]));

        int N = intervals.length;
        int count = 0, start = intervals[N-1][0];
        
        for(int i=N-2; i>=0; i--){
            if(intervals[i][1] > start){
                count++;
            }
            else{
                start = intervals[i][0];
            }
        }
        
        return count;
    }
}
