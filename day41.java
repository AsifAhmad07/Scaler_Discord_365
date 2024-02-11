public class day41 {


    Name Of The Problem :- Largest Coprime Divisor


    Date :- 11-feb-2024


    Problem Description
 
 

You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1
For example,

A = 30
B = 12
We return
X = 5


Problem Constraints
1<=A,B<=1e9


Input Format
First argument is A.
Second argument is B.


Output Format
Find the maximum valued integer X which satisfies the above properties.


---------------------------------------------------------------------------------------------------




public class Solution {
    public int cpFact(int x, int y) {
        while (gcd(x, y) != 1) {
            x = x / gcd(x, y);
        }
        return x;
    }
    
    public int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(Math.min(A,B), Math.max(A,B)%Math.min(A, B));
    }
}

    
}
