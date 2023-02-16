package graph;

import java.util.LinkedList;
import java.util.Queue;

//		Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
//		Each cell can have three values:
//		The value 0 representing an empty cell.
//		The value 1 representing a fresh orange.
//		The value 2 representing a rotten orange.
//		Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) 
//		to a rotten orange becomes rotten. Return the minimum number of minutes that must 
//		elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
//		Input :						    	Output:
//			A =  [ [2, 1, 1]					4
//			        [1, 1, 0]
//			        [0, 1, 1] ]
public class RottenOranges {
	class Pair {
		int first;
		int second;
		Pair(int first, int second) { // created Pair class and initialized its constructor
			this.first = first;
			this.second = second;
		}
	}

	public int solve(int[][] A) {
		Queue<Pair> q = new LinkedList<>(); // Queue for storing elements level by level

		int R = A.length;
		int C = A[0].length;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] == 2) { // checked source rotten oranges and pushed in Queue at once
					q.add(new Pair(i, j));
				}
			}
		}

		int level = 0; // Initial level will be zero for all source nodes

		while (q.size() > 0) { // Pushing all elements at once deleting them , traversing on next level
			int n = q.size();
			level = level + 1;

			for (int i = 0; i < n; i++) {
				Pair ele = q.poll();
				int x = ele.first;
				int y = ele.second; // (x-1,y) (x+1,y) (x,y-1) (x,y+1) Those are four cases

				if (x - 1 >= 0 && A[x - 1][y] == 1) { // if element is 1 and within constraints
					A[x - 1][y] = 2;
					q.add(new Pair(x - 1, y)); // made visited element rotten==2 and added that element to Queue
				}
				if (x + 1 < R && A[x + 1][y] == 1) {
					A[x + 1][y] = 2;
					q.add(new Pair(x + 1, y));
				}
				if (y - 1 >= 0 && A[x][y - 1] == 1) {
					A[x][y - 1] = 2;
					q.add(new Pair(x, y - 1));
				}
				if (y + 1 < C && A[x][y + 1] == 1) {
					A[x][y + 1] = 2;
					q.add(new Pair(x, y + 1));
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] == 1) { // if at all any element is 1 that means its not rotten after all process
					return -1;
				}
			}
		}

		return level - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
