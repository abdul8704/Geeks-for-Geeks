// The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.

// Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.

// Examples:

// Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
// Output: 865
// Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.


// Input: prices[] = [4, 2, 2, 2, 4]
// Output: 2
// Explanation: Buy the stock on day 3 and sell it on day 4 => 4 – 2 = 2. Maximum Profit = 2.
// Constraints:
// 1 <= prices.size() <= 105
// 0 <= prices[i] <= 104
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length==1) return 0;
        int profit = 0;
        int sell = prices.length - 1;

        for(int i = prices.length-2; i>=0; i--){
            if(prices[sell-1] > prices[sell]){
                sell = i;
            }
            else if(prices[i] > prices[i+1]){
                profit += (prices[sell] - prices[i+1]);
                sell = i;
            }
            
        }
        
        profit += (prices[sell] - prices[0]);
        return profit;
    }
}