public class day105 {


    Name Of The Problem :- Capacity To Ship Packages Within B Days


    Date :- 15-April-2024

    Problem Description
 
 

A conveyor belt has packages that must be shipped from one port to another within B days.

The ith package on the conveyor belt has a weight of A[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within B days.



Problem Constraints
1 <= B <= |A| <= 5 * 105
1 <= A[i] <= 105


Input Format
First argument is array of integers A denoting the weights.

Second argument is the integer B denoting the number of days. 



Output Format
Return the least weight capacity of the ship.


Example Input
Input 1:
A = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
B = 5
Input 2:

A = [3, 2, 2, 4, 1, 4]
B = 3


Example Output
Ouput 1:
15
Ouput 2:

6


Example Explanation
Explanation 1:
A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10
Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and 
splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Explanation 2:

A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4


-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int solve(int[] A, int B) {
        long max = A[0], sum = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i]);
            sum += A[i];
        }
        long l = max, r = sum, res = -1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (canShip(A, B, mid)) {
                res = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return (int) res;
    }
    private static boolean canShip(int[] A, int B, long capacity) {
        long curr = 0;

        for (int val : A) {
            curr += val;
            if (curr > capacity) {
                B--;
                if (B <= 0)
                    return false;

                curr = val;
            }
        }
        return true;
    }

}

    
}
