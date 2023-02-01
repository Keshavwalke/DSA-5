package dynamicProgramming;

import java.util.Arrays;

//		You are climbing a staircase and it takes A steps to reach the top.

//		Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//		Return the number of distinct ways modulo 1000000007
//		Input :				Output:
//			 A = 3				3

public class Stairs {
	// Using Memoization
	int m = 1000000007;

	public int climbStairs2(int A) {
		int dp[] = new int[A + 1]; // created dp array
		Arrays.fill(dp, -1); // filled dp array
		dp[0] = 0;
		dp[1] = 1; // filled 0th and 1st index
		return helper(dp, A); // return helper function
	}

	public int helper(int[] dp, int A) {
		if (A <= 2)
			return A; // base condition
		if (dp[A] == -1) { // if -1 means calling for the first time
			dp[A] = (helper(dp, A - 1) % m + helper(dp, A - 2) % m) % m;
		}
		return dp[A];
	}
	
	
	
	//Using Tabulation
	public static int climbStairs(int A) {
		int dp[] = new int[A + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= A; i++) {
			if (A <= 1) {
				return A;
			}
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}
		return dp[A];
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(3));

	}

}
