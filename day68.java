import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day68 {

    Name Of The Problem :- Diffk II


    Date :- 09-march-2024


    Problem Description
 
 

Given an array A of integers and another non negative integer B .

Find if there exists 2 indices i and j such that A[i] - A[j] = B and i != j.



Problem Constraints
1 <= |A| <= 106

0 <= A[i] <= 109

0 <= B <= 109



Input Format
First argument A is an array of integer

Second argument B is an integer



Output Format
Return 1 if two such indexes are found and 0 otherwise


Example Input
Input 1:
A = [1, 5, 3]
B = 2
Input 2:
A = [2, 4, 3]
B = 3


Example Output
Output 1:
1
Output 2:
0


Example Explanation
For Input 1:
The given value of A[1] = 1 and A[3] = 3.
The value of A[3] - A[1] = 2.
For Input 2:
There are no pairs such that difference is B.

-----------------------------------------------------------------------------------------------------------------------------------------------------
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        
        if (A.size() <= 1) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (set.contains(num + B) || set.contains(num - B)) {
                return 1;
            }
            set.add(num);
        }
        
        return 0;
    }
}
    
}
