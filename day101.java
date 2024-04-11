public class day101 {


    Name Of The Problem :- City Tour


    Date :- 11-April-2024

    Problem Description
 
 

There are A cities numbered from 1 to A. You have already visited M cities, the indices of which are given in an array B of M integers.

 

If a city with index i is visited, you can visit either the city with index i-1 (i >= 2) or the city with index i+1 (i < A) if they are not already visited. Eg: if N = 5 and array M consists of [3, 4], then in the first level of moves, you can either visit 2 or 5.

You keep visiting cities in this fashion until all the cities are not visited. Find the number of ways in which you can visit all the cities modulo 10^9+7. 



Problem Constraints
1 <= A <= 1000
1 <= M <= A
1 <= B[i] <= A


Input Format
The 1st argument given is an integer A, i.e total number of cities.
The 2nd argument given is an integer array B, where B[i] denotes ith city you already visited.


Output Format
Return an Integer X % (1e9 + 7), the number of ways in which you can visit all the cities.


Example Input
A = 5
B = [2, 5]


Example Output
6


Example Explanation
All possible ways to visit remaining cities are :
1. 1 -> 3 -> 4
2. 1 -> 4 -> 3
3. 3 -> 1 -> 4
4. 3 -> 4 -> 1
5. 4 -> 1 -> 3
6. 4 -> 3 -> 1


-----------------------------------------------------------------------------------------------------------------------------------------------------
public class Solution {
    public int solve(int A, int[] B) {
         int p = 1000000007, m = B.length;
        if (A == m)
            return 0;
        long[] fact = modFact(A - m, p);
        Arrays.sort(B);
        int[] X = new int[m + 1];
        X[0] = B[0] - 1;
        for (int i = 1; i < m; i++)
            X[i] = B[i] - B[i - 1] - 1;
        X[m] = A - B[m - 1];
        long num = fact[A - m];
        long den = fact[X[0]];
        for (int i = 1; i <= m; i++)
            den = (den * fact[X[i]]) % p;

        long comb = (num * modInverse(den, p)) % p;
        int pow = 0;
        for (int i = 1; i < m; i++)
            pow += Math.max(0, X[i] - 1);
        long choices = modPower(2, pow, p);

        return (int) ((comb * choices) % p);
    }
    private static long[] modFact(int n, int p) {
        long[] fact = new long[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++)
            fact[i] = (fact[i - 1] * i) % p;

        return fact;
    }
      private static long modInverse(long a, int p) {
        return modPower(a, p - 2, p);
    }
    private static long modPower(long x, int y, int p) {
        long res = 1;

        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            x = (x * x) % p;
            y /= 2;
        }

        return res;
    }
}

    
}
