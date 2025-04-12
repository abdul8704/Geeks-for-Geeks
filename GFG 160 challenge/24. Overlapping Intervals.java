// Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

// Examples:
// Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
// Output: [[1,4], [6,8], [9,10]]
// Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].

// Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
// Output: [[1,9]]
// Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].

// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ starti ≤ endi ≤ 105

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (a, b) -> (a[0] == b[0])? Integer.compare(a[1], b[1]): Integer.compare(a[0], b[0]));
        
        List<int[]> res = new ArrayList<>(); 
        int top = -1;
        
        for(int i=0; i<arr.length; i++){
            if(i == 0 || arr[i][0] > res.get(top)[1]){
                res.add(arr[i]);
                top++;
            }
                
            else{
                int[] temp = res.get(top);
                temp[1] = Math.max(temp[1], arr[i][1]);
                res.set(top, temp);
            }
        }
        
        return res;
        
    }
}
