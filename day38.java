import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class day38 {


    Name Of The Problem :- Maximum Consecutive Gap

    Date :- 08-feb-2024



    Problem Description
 
 

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.
You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
Try to solve it in linear time/space



Problem Constraints
1 <= |A| <= 106
1 <= Ai <= 109


Input Format
The first argument is an integer array A.


Output Format
Return an integer representing maximum difference between the successive elements in array A.


Example Input
A = [1, 10, 5]


Example Output
5


Example Explanation
The maximum difference is between 5 and 10, which is 5.

-------------------------------------------------------------------------------------------------------------------------



public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        
        if (A.size() < 2) return 0;
        
        Set<Integer> set = new TreeSet<>(A);
        int i = 0;
        int prev = -1;
        int max = Integer.MIN_VALUE;
        
        for (int num : set) {
            if (i == 0) {
                prev = num;
                i = 1;
            }
            else {
                max = Math.max(max, num - prev);
                prev = num;
            }
        }
        
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}

    
}
