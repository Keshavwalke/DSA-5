package dynamicProgramming;

//		Given two integer arrays A and B of size N each which represent values 
//		and weights associated with N items respectively.
//		Also given an integer C which represents knapsack capacity.
//		Find out the maximum value subset of A such that sum of the 
//		weights of this subset is smaller than or equal to C.
//		NOTE:
//		You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
//		Input :							Output:
//			 A = [60, 100, 120]				220
//			 B = [10, 20, 30]
//			 C = 50
public class Knapsack {
	public static int solve(int[] A, int[] B, int C) {
		int N = A.length;
		int dp[][] = new int[N][C + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= C; j++) { // filling dp array with -1
				dp[i][j] = -1;
			}
		}
		helper(A.length - 1, C, A, B, dp);
		return dp[N - 1][C];
	}

	public static int helper(int i, int j, int A[], int B[], int dp[][]) {
		if (i < 0 || j == 0)
			return 0; // Base case
		if (dp[i][j] == -1) {
			int a = helper(i - 1, j, A, B, dp); // leave it case
			if (j >= B[i]) {
				a = Math.max(a, (helper(i - 1, j - B[i], A, B, dp)) + A[i]); // pick it case , i-1 and weight removing
			}
			dp[i][j] = a;
		}
		return dp[i][j];
	}

	public static void main(String[] args) {
		int [] A = {60, 100, 120};
		int [] B = {10, 20, 30};
		int C = 50;
		System.out.println(solve(A,B,C));

	}

}
