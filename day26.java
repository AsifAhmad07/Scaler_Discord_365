import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class day26 {

    Name of The Problem :- Largest Number

    Date :- 27-jan-2024

    Problem Description
 
 

Given a list of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.


Problem Constraints
1 <= |A| <= 105
0 <= Ai <= 109


Input Format
The first argument is an integer array A.


Output Format
Return a string representing the largest number formed


Example Input
A = [3, 30, 34, 5, 9]


Example Output
9534330


Example Explanation
Largest possible number that can be formed is 9534330


-----------------------------------------------------------------------------------------------------------------

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        String s1 = String.valueOf(o1);
        String s2 = String.valueOf(o2);
        String XY = s1 + s2;
        String YX = s2 + s1;
        return XY.compareTo(YX) > 0 ? -1 : 1;
      }
    });
    pq.addAll(A);
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      sb.append(pq.poll());
    }
    return sb.charAt(0) == '0' ? "0" :sb.toString();
    }
}

    
}
