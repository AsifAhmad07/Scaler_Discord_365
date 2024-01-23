import java.util.Arrays;

public class day14 {
    /*
     * Name Of The Problem :- Noble Integer
     * 
     * Problem Description
 
 

Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.



Problem Constraints
1 <= |A| <= 106
-109 <= Ai <= 109


Input Format
First and only argument is an integer array A.



Output Format
Return 1 if any such integer p is found else return -1.



Example Input
Input 1:

 A = [3, 2, 1, 3]
Input 2:

 A = [1, 1, 3, 3]


Example Output
Output 1:

 1
Output 2:

 -1


Example Explanation
Explanation 1:

 For integer 2, there are 2 greater elements in the array. So, return 1.
Explanation 2:

 There is no such integer exists.


     */
    public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        if(A[n-1] == 0){
            return 1;
        }
        for(int i = 0; i < n-1; i++){
            if(A[i] == A[i + 1])
            continue;
            else{
                if(A[i] == n- 1 - i) return 1;
            }
        }
        return -1;
    
    }
}
    
}
