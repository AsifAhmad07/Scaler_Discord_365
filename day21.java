import java.util.ArrayList;

public class day21 {

    /*
     * Name Of The Problem :- Max Non Negative SubArray
     * Day 21 
     * 
     * Problem Description

Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

Find and return the required subarray.

NOTE:  

If there is a tie, then compare with segment's length and return segment which has maximum length.
If there is still a tie, then return the segment with minimum starting index.


Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109



Input Format
The first and the only argument of input contains an integer array A, of length N.



Output Format
Return an array of integers, that is a subarray of A that satisfies the given conditions.



Example Input
Input 1:

 A = [1, 2, 5, -7, 2, 3]
Input 2:

 A = [10, -1, 2, 3, -4, 100]


Example Output
Output 1:

 [1, 2, 5]
Output 2:

 [100]


Example Explanation
Explanation 1:

 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3].
Explanation 2:

 The three sub-arrays are [10], [2, 3], [100].
 The answer is [100] as its sum is larger than the other two.

     */



     public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
         ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> copy = new ArrayList<>();
        long sum = 0;
        long temp = 0;

        for (int num : A) {
            if (num >= 0) {
                temp += num;
                copy.add(num);
            }
            else {
                temp = 0;
                copy.clear();
            }
            
            if (temp > sum || (temp == sum && ans.size() < copy.size())) {
                sum = temp;
                ans.clear();
                ans.addAll(copy);
            }
        }

        return ans;
    }
}

    
}
