package dynamicProgramming;

import java.util.Arrays;

//		In Danceland, one person can party either alone or can pair up with another person.
//		Can you find in how many ways they can party if there are A people in Danceland?
//		Note: Return your answer modulo 10003, as the answer can be large.
public class LetsParty {
	int[] dp;

	public int solve(int A) {
		dp = new int[A + 1];
		Arrays.fill(dp, -1);
		return dance(A);
	}

	public int dance(int N) {
		if (N <= 2) {
			return N;
		}
		if (dp[N] == -1) {
			dp[N] = dance(N - 1) + dance(N - 2) * (N - 1);
		}
		return dp[N] % 10003;
	}

}
