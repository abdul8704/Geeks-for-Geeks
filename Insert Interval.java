// Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.
// Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Examples:

// Input: intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
// Output: [[1,3], [4,7], [8,10]]
// Explanation: The newInterval [5,6] overlaps with [4,5] and [6,7].

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,9]
// Output: [[1,2], [3,10], [12,16]]
// Explanation: The new interval [4,9] overlaps with [3,5],[6,7],[8,10].

// Constraints:
// 1 ≤ intervals.size() ≤  105
// 0 ≤ start[i], end[i] ≤ 109

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        
        while(i < intervals.length){
            if(intervals[i][0] < newInterval[0]){
                add(res, intervals[i], res.size()-1);   
            }
            else{
                add(res, newInterval, res.size()-1);
                break;
            }
            i++;
        }
        
        while(i < intervals.length){
            add(res, intervals[i], res.size()-1);
            i++;
        }
        
        if(i != intervals.length + 1)
            add(res, newInterval, res.size()-1);
        
        return res;
    }
    private static void add(ArrayList<int[]> res, int[] interval, int top){
        
        if(top == -1 || res.get(top)[1] < interval[0])
            res.add(interval);
        else{
            res.get(top)[1] = Math.max(interval[1], res.get(top)[1]);
        }    
    }    
}