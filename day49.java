public class day49 {


    Name Of The Problem :- First Missing Integer

    Date :- 19-feb-2024

    Problem Description
 
 

Given an unsorted integer array, find the first missing positive integer.
Your algorithm should run in O(n) time and use constant space.


Problem Constraints
1 <= |A| <= 106
-106 <= Ai <= 106


Input Format
The first argument is an integer array A.


Output Format
Return an integer equal to the first missing positive integer


Example Input
Input 1:
A = [1,2,0]
Input 2:
A = [3,4,-1,1]
Input 3:
A = [-8,-7,-6]


Example Output
Output 1:
3
Output 2:
2
Output 3:
1


Example Explanation
Explanation 1:
3 is the first positive missing integer.
Explanation 2:
2 is the first positive missing integer.
Explanation 3:
1 is the first positive missing integer.


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        
    int n = A.size();
    int idx = 0;
    while (idx < n) {
      if (A.get(idx) == (idx + 1) || A.get(idx) <= 0 || A.get(idx) > n) {
        idx++;
        continue;
      }
      int idx1 = idx;
      int idx2 = A.get(idx) - 1;
      if (A.get(idx2) != A.get(idx1)) {
        int temp = A.get(idx1);
        A.set(idx1, A.get(idx2));
        A.set(idx2, temp);
      }
      else {
        idx++;
      }
    }
    idx = 0;
    while (idx < n && A.get(idx) == idx + 1) {
      idx++;
    }
    return idx + 1;
    }
}

    
}
