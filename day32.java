public class day32 {


    Name Of The Problem :- Prime Sum

    Date :- 02-feb-2024


    Problem Description
 
 

    Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
    If there is more than one solution possible, return the lexicographically smaller solution i.e.
    If [a, b] is one solution with a <= b,
    and [c,d] is another solution with c <= d, then
    
    [a, b] < [c, d] 
    If a < c OR ( a == c AND b < d ).
    NOTE: A solution will always exist. read Goldbach's conjecture
    
    
    Problem Constraints
    1 <= A <= 2 * 107
    
    
    Input Format
    The first argument is an integer A.
    
    
    Output Format
    Return an array of integers.
    
    
    Example Input
    4
    
    
    Example Output
    [2, 2]
    
    
    Example Explanation
    2 + 2 equals 4, which is the lexicographically smaller solution


    -----------------------------------------------------------------------------------------------
    
    public class Solution {
        public ArrayList<Integer> primesum(int A) {
            ArrayList<Integer> ans = new ArrayList<>();
            ArrayList<Integer> primes = sieve(A);
            boolean flag = false;
            
            for (int i=0;i<primes.size();i++) {
                for (int j=i; j<primes.size();j++) {
                    if (primes.get(i) + primes.get(j) == A) {
                        ans.add(primes.get(i));
                        ans.add(primes.get(j));
                        flag = true;
                        break;
                    }
                }
                
                if (flag) break;
            }
            
            return ans;
        }
        
        public ArrayList<Integer> sieve(int A) {
            boolean[] isPrime = new boolean[A+1];
    
            for (int i=2; i<=A; i++) {
                if (!isPrime[i]) {
                    for (int j=2;j*i<=A;j++) {
                        isPrime[i*j] = true;
                    }
                }
            }
    
            ArrayList<Integer> ans = new ArrayList<>();
    
            for (int i=2;i<A+1;i++) {
                if (!isPrime[i]) {
                    ans.add(i);
                }
            }
    
            return ans;
        }
    }
    
}
