// Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.

// H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

// Examples:

// Input: citations[] = [3, 0, 5, 3, 0]
// Output: 3
// Explanation: There are at least 3 papers (3, 5, 3) with at least 3 citations.

// Input: citations[] = [5, 1, 2, 4, 1]
// Output: 2
// Explanation: There are 3 papers (with citation counts of 5, 2, and 4) that have 2 or more citations. However, the H-Index cannot be 3 because there aren't 3 papers with 3 or more citations.

// Input: citations[] = [0, 0]
// Output: 0

// Constraints:
// 1 ≤ citations.size() ≤ 106
// 0 ≤ citations[i] ≤ 106

class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) { //sort the array and then binary search
        Arrays.sort(citations);
        int h = 0, n = citations.length;
        int left = 0, right = n-1, mid = 0;

        while(left <= right){
            mid = left + (right - left)/2;

            if(citations[mid] == n-mid){
                return citations[mid];
            }
            else if(citations[mid] < n-mid){
                left = mid +1;
            }
            else{
                right = mid - 1;
            }
        }
        return n-left;
    }
    public int hIndexb(int[] citations) {  //implement count sort
        int n = citations.length;
        int[] paper_count = new int[n+1];
        
        for(int i=0; i<n; i++){
            if(citations[i] > n)
                paper_count[n]++;
            else
                paper_count[citations[i]]++;
        }
        
        int papers = 0;
        for(int i=n; i>=0 ;i--){
            papers += paper_count[i];
            if(i <= papers){
                return i;
            }
        }
        return 0;
    }
}