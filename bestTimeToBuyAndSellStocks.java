public class bestTimeToBuyAndSellStocks {
    /* 
     * Day - 06
     * Name Of The Problem :- Best Time to Buy and Sell Stocks I
     * 
     * Problem Description

Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.



Problem Constraints
0 <= len(A) <= 7e5

1 <= A[i] <= 1e7



Input Format
The first and the only argument is an array of integers, A.



Output Format
Return an integer, representing the maximum possible profit.



Example Input
Input 1:

 A = [1, 2]
Input 2:

 A = [1, 4, 5, 2, 4]


Example Output
Output 1:
 1
Output 2:

 4


Example Explanation
Explanation 1:

 Buy the stock on day 0, and sell it on day 1.
Explanation 2:

 Buy the stock on day 0, and sell it on day 2.



     */
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int maxProfit(final int[] A) {
            int buyPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for(int i = 0; i < A.length;i++){
                if(buyPrice < A[i]){
                    int profit = A[i] - buyPrice;
                    maxProfit = Math.max(maxProfit , profit);
                }
                else{
                    buyPrice = A[i];
                }
            }
            return maxProfit;
        }
    }
    
    
}
