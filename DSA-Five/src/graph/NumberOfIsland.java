package graph;

//		Given a matrix of integers A of size N x M consisting of 0 and 1.
//		A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 
//		you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
//		More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
//		(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
//		(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
//		(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
//		(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
//		(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
//		(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
//		(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
//		(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
//		Return the number of islands.
//		NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
//		Input 1:						Output:
//			 A = [ [0, 1, 0]				2
//			       [0, 0, 1]			The 1's at position A[0][1] and A[1][2] forms one island. 
//			       [1, 0, 0]]			Other is formed by A[2][0].

public class NumberOfIsland {
	public int solve(int[][] A) {
		int count = 0;
		int N = A.length;
		int M = A[0].length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {		//iterate over all elements of matrix
				if (A[i][j] == 1) {			//once travelled it'll make adjacent elements 0
					count++;
					dfs(A, i, j);
				}
			}
		}
		return count;
	}

	public void dfs(int A[][], int i, int j) {
		if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == 0)
			return;
		A[i][j] = 0;
		dfs(A, i - 1, j);
		dfs(A, i, j - 1);
		dfs(A, i + 1, j);				//this logic has took diagonals as well, tweak a little bit and done
		dfs(A, i, j + 1);
		dfs(A, i - 1, j - 1);
		dfs(A, i + 1, j + 1);
		dfs(A, i - 1, j + 1);
		dfs(A, i + 1, j - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
