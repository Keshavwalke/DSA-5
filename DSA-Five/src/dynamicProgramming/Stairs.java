package dynamicProgramming;
//		You are climbing a staircase and it takes A steps to reach the top.

//		Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//		Return the number of distinct ways modulo 1000000007
//		Input :				Output:
//			 A = 3				3

public class Stairs {
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
