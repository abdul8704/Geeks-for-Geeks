// You are given two arrays: pages[] and shelf[], where pages[i] represents the number of pages in the i-th book, and shelf[i]
// indicates the shelf on which the i-th book is currently placed. The objective is to rearrange the books such that each shelf
// contains exactly one book. The cost of removing a book from a shelf is equal to the number of pages in that book.

// Find the minimum total cost required to arrange the books so that every given shelf holds exactly one book.

// Examples:

// Input: pages[] = [9, 10, 5, 4], shelf[] = [1, 3, 5,5]
// Output: 4
// Explanation: shelf 5 holds 2 books, so it's optimal to remove the book with 4 pages.

// Input: pages[] = [1, 5, 4], shelf[] = [7, 7, 7]
// Output: 5
// Explanation: shelf 7 holds 3 books, so it's optimal to remove the books with 1 and 4 pages.

// Input: pages[] = [5, 11, 6], shelf[] = [2, 7,1]
// Output: 0
// Explanation: Since each shelf holds exactly one book, minimum cost to rearrange them will be 0.

// Constraints:
// 1≤ pages.size()=shelf.size() ≤105
// 1≤ pages[i], shelf[i] ≤105

import java.util.HashMap;

class Solution {
    public int rearrange(int[] pages, int[] shelf) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = pages.length, cost = 0;
        for(int i=0; i<N; i++){
            if(map.containsKey(shelf[i])){
               int curBook = map.get(shelf[i]);
               cost += Math.min(curBook, pages[i]);
               map.put(shelf[i], Math.max(curBook, pages[i]));
            }
            else{
               map.put(shelf[i], pages[i]);
            }
        }

        
        return cost;
    }
}