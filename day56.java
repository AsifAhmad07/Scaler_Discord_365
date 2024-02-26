import java.util.ArrayList;

import javax.swing.text.Position;

public class day56 {


    Name Of The Problem :- Sorted Insert Position


    Date :- 26-feb-2024


    Problem Description

Given a sorted array A and a target value B, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= 109



Input Format
First argument is array A.

Second argument is integer B.



Output Format
Return an integer, the answer to the problem.



Example Input
Input 1:

 A = [1, 3, 5, 6]
B = 5
Input 2:

 A = [1, 3, 5, 6]
B = 2


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 5 is found at index 2.
Explanation 2:

 2 will be inserted ar index 1.


-----------------------------------------------------------------------------------------------------------------------------------------------------



public class Solution {
	public int searchInsert(ArrayList<Integer> a, int b) {
        
    int start = 0;
    int end = a.size() - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (a.get(mid) == b) {
        return mid;
      }
      else if (a.get(mid) < b) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    return start;
	}
}

    
}
