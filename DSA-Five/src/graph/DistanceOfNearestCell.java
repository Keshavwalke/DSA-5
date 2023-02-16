package graph;

import java.util.LinkedList;
import java.util.Queue;

//	Given a matrix of integers A of size N x M consisting of 0 or 1.
//	For each cell of the matrix find the distance of nearest 1 in the matrix.
//	Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
//	Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.
//			Input:								Output:
//				 [0, 0, 0, 1]						[3, 2, 1, 0]
//				 [0, 0, 1, 1] 					    [2, 1, 0, 0]
//				 [0, 1, 1, 0]                       [1, 0, 0, 1]  
public class DistanceOfNearestCell {
	public int[][] solve(int[][] A) {
		int R = A.length;
		int C = A[0].length;
		Queue<Pair> q = new LinkedList<>();

		int B[][] = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				B[i][j] = -1; // Initialized result array
				if (A[i][j] == 1) { // if element is 1 then its level will be 0
					q.add(new Pair(i, j)); // pushed that to queue
					B[i][j] = 0;
				}
			}
		}

		int level = 0;
		while (q.size() > 0) {
			int N = q.size(); // Iterate over all elements adjacent to those elements
			level = level + 1; // adjacent's level will be level+1
			for (int i = 0; i < N; i++) {
				Pair ele = q.poll();
				int x = ele.first;
				int y = ele.second;

				if (x - 1 >= 0 && B[x - 1][y] == -1) { // (x-1,y) (x+1,y) (x,y-1) (x,y+1)
					B[x - 1][y] = level;
					q.add(new Pair(x - 1, y)); // given the level and pushed in queue
				}
				if (x + 1 < R && B[x + 1][y] == -1) { // B[][]=-1 means it is not visited
					B[x + 1][y] = level;
					q.add(new Pair(x + 1, y));
				}
				if (y - 1 >= 0 && B[x][y - 1] == -1) {
					B[x][y - 1] = level;
					q.add(new Pair(x, y - 1));
				}
				if (y + 1 < C && B[x][y + 1] == -1) {
					B[x][y + 1] = level;
					q.add(new Pair(x, y + 1));
				}
			}
		}
		return B;
	}

	class Pair {
		int first;
		int second;

		Pair(int first, int second) { // created class pair
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
		

	}

}
