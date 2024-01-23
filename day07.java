public class day07 {
    /*
     * 
     * Name Of THe Problem - Verify Prime
     * Day - 07
     * Given a number N, verify if N is prime or not.

Return 1 if N is prime, else return 0.

Example :

Input : 7
Output : True
Problem Approach:

VIDEO : https://www.youtube.com/watch?v=7VPA-HjjUmU

Complete code in the hint.


     */
    public class Solution {
        public int isPrime(int A) {
             int count = 0;
            int temp = (int)Math.sqrt(A);
            for(int i = 1; i  <= temp;i++){
                if(A % i == 0){
                    if(i   == A /i){
                        count++;
                    }
                    else{
                        count +=2;
                    }
                }
    
            }
             if(count == 2){
                return 1;
             }
            
            return 0;
        }
    }
    
    
}
