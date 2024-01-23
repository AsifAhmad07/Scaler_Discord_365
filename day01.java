public class day01 {

    /*
     * Day - 01
     * NameOfTheProblem  - Number of 1 Bits
     * Day :- 01    
     * Problem Description
 
 

Write a function that takes an integer and returns the number of 1 bits it has.


Problem Constraints
0 <= A <= 4294967295


Input Format
First and only argument contains integer A


Output Format
Return an integer as the answer


Example Input
Input1:
    11


Example Output
Output1:
3


Example Explanation
Explaination1:
11 is represented as 1101 in binary 
     */
    public class Solution {
        boolean checkbit(long A, int i){
           if((A & (1 << i)) == 0){
               return false;
           }
           else{
               return true;
           }
       }
       public int numSetBits(long a) {
            int count = 0;
           for(int i = 0; i <= 31;i++){
               if(checkbit(a,i) == true){
                   count++;
               }
           }
           return count;
       }
   }
}