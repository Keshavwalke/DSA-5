package dynamicProgramming;

import java.util.Arrays;

//		Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
//		Input :				Output:
//			 A = 6				3
public class MinimumSquares {
	public int countMinSquares(int A) {
		int dp[] = new int[A + 1];
		Arrays.fill(dp, -1);
		return solve(A, dp);
	}

	public int solve(int A, int[] dp) {
		if (A == 0)
			return 0;

		if (dp[A] == -1) {
			int ans = Integer.MAX_VALUE;
			for (int j = 1; j * j <= A; j++) {
				ans = Math.min(ans, solve(A - j * j, dp) + 1);
			}
			dp[A] = ans;
		}

		return dp[A];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
