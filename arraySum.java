import java.util.ArrayList;
import java.util.Collections;

public class arraySum {
    /*
     * Day - 03 
     * NameOfTheProblem  - ArraySum
     * Problem Description
 
 

You are given two numbers represented as integer arrays A and B, where each digit is an element.
 You have to return an array which representing the sum of the two given numbers.

The last element denotes the least significant bit, and the first element denotes the most significant bit.

Note : Array A and Array B can be of different size. ( i.e. length of Array A may not be equal to length of Array B ).



Problem Constraints
1 <= |A|, |B| <= 105
0 <= Ai, Bi <= 9


Input Format
The first argument is an integer array A. The second argument is an integer array B.


Output Format
Return an array denoting the sum of the two numbers.


Example Input
Input 1:
A = [1, 2, 3]
B = [2, 5, 5]
Input 2:

A = [9, 9, 1]
B = [1, 2, 1]


Example Output
Output 1:
[3, 7, 8]
Output 2:

[1, 1, 1, 2]


Example Explanation
Explanation 1:
Simply, add all the digits in their place.
Explanation 2:

991 + 121 = 1112
Note that the resultant array size might be larger.
     */
    public class Solution {
    public ArrayList<Integer> addArrays(ArrayList<Integer> A, ArrayList<Integer> B) {
   Collections.reverse(A);
    Collections.reverse(B);
    
    while(A.size() < B.size()){
        A.add(0);
    }
    while(B.size() < A.size()){
        B.add(0);
    }
        
        
    ArrayList<Integer>ans = new ArrayList<>();
    int carry=0;
    for(int i=0;i<A.size();i++)
    {
        int n=carry+A.get(i)+B.get(i);
        
        ans.add(n%10);
        carry=n/10;
        
    }
    if(carry != 0){
        ans.add(carry);
    }
    Collections.reverse(ans);
    return ans;
    }
}

    
}
