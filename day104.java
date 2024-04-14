public class day104 {


    Name Of The Problem :- Simple Queries

    Date :- 14-April-2024

    Problem Description
 
 

You are given an array A having N integers.

You have to perform the following steps in a given order.

1) generate all subarrays of A.

2) take the maximum element from each subarray of A and insert it into a new array G.

3) replace every element of G with the product of their divisors mod 1e9 + 7.

4) sort G in descending order

You now need to perform Q queries

In each query, you are given an integer K, where you have to find the Kth element in G.

NOTE : Your solution will run on multiple test cases so do clear global variables after using them.



Problem Constraints
1 <= N <= 1e5

1 <= A[i] <= 1e5

1 <= Q <= 1e5

1 <= k <= (N * (N + 1))/2 



Input Format
The first argument given is an Array A, having N integers.

The second argument given is an Array B, where B[i] is the ith query.



Output Format
Return an Array X, where X[i] will have the answer for the ith query.



Example Input
Input 1:

 A = [1, 2, 4]
B = [1, 2, 3, 4, 5, 6]
Input 2:

 A = [1, 3]
B = [1]


Example Output
Output 1:

 [8, 8, 8, 2, 2, 1]
Output 2:

 [3]


Example Explanation
Explanation 1:

 subarrays of A    maximum element
[1] 1
[1, 2] 2
[1, 2, 4] 4
[2] 2
[2, 4] 4
[4] 4
original
G = [1, 2, 4, 2, 4, 4]

after changing every element of G with product of their divisors
G = [1, 2, 8, 2, 8, 8]

after sorting G in descending order
G = [8, 8, 8, 2, 2, 1]



Explanation 2:

 Just perform given query.


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int[] solve(int[] A, int[] B) {
        int n = A.length;
        int[] next = findNextGreater(A);
        int[] prev = findPreviousGreater(A);
        ProductNode[] G = new ProductNode[n];

        for (int i = 0; i < n; i++) {
            int leftCount = i - prev[i];
            int rightCount = next[i] - i;
            G[i] = new ProductNode(productOfFactors(A[i]), (long) leftCount * rightCount);
        }
        Arrays.sort(G, (p1, p2) -> p2.val - p1.val);
        long[] freqSum = new long[n];
        freqSum[0] = G[0].freq;
        for (int i = 1; i < n; i++)
            freqSum[i] = freqSum[i - 1] + G[i].freq;
        for (int i = 0; i < B.length; i++) {
            int pos = queryFrequencies(freqSum, B[i]);
            B[i] = G[pos].val;
        }

        return B;
    }
    private static int queryFrequencies(long[] freqSum, int x) {
        int n = freqSum.length;
        int l = 0, r = n - 1, res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (freqSum[mid] == x)
                return mid;
            if (freqSum[mid] < x)
                l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }

        return res;
    }
    private static int[] findPreviousGreater(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        res[n - 1] = -1;
        Stack<Integer> s = new Stack<>();
        s.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            res[i] = -1;
            while (!s.empty() && A[s.peek()] <= A[i])
                res[s.pop()] = i;

            s.push(i);
        }

        return res;
    }
    private static int[] findNextGreater(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        res[0] = n;
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for (int i = 1; i < n; i++) {
            res[i] = n;
            while (!s.empty() && A[s.peek()] < A[i])
                res[s.pop()] = i;

            s.push(i);
        }

        return res;
    }
    private static int countFactors(int x) {
        int cnt = 0;

        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                cnt += (x / i == i) ? 1 : 2;
            }
        }

        return cnt;
    }
    private static int productOfFactors(int x) {
        int cnt = countFactors(x), p = 1000000007;
        int res = pow(x, cnt / 2, p);
        if (cnt % 2 == 1)
            res = (int) ((res * (long) Math.sqrt(x)) % p);

        return res;
    }
    private static class ProductNode {
        int val;
        long freq;

        ProductNode(int val, long freq) {
            this.val = val;
            this.freq = freq;
        }
    }
     static int pow(int x, int n, int d) {
        if (x == 0)
            return 0;
        long x1 = x, res = 1;

        while (n > 0) {
            if (n % 2 == 1)
                res = (res * x1) % d;
            x1 = (x1 * x1) % d;
            n /= 2;
        }
        res = (res + d) % d;
        return (int) res;
    }
}

    
}
