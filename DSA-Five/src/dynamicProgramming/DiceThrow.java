package dynamicProgramming;
//		Given sum A, number of ways you can get that sum with dice roll[1-6].

//		As the number of ways can be large return its modulo by 1e9 + 7.

public class DiceThrow {
	int m = 1000000007;

	public int solve(int A) {
		int[] dp = new int[A + 1];
		dp[0] = 1;
		for (int i = 1; i <= A; i++) {
			dp[i] = 0;
			for (int j = 1; j <= 6; j++) {
				if (i - j >= 0) {
					dp[i] = (dp[i] % m + dp[i - j] % m) % m;
				}
			}
		}
		return dp[A];
	}
}
