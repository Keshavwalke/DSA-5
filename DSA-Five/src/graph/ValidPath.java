package graph;

import java.util.LinkedList;
import java.util.Queue;

//		There is a rectangle with left bottom as (0, 0) and right up as (x, y).
//		There are N circles such that their centers are inside the rectangle.
//		Radius of each circle is R. Now we need to find out if it is possible that 
//		we can move from (0, 0) to (x, y) without touching any circle.
//		Note : We can move from any cell to any of its 8 adjecent neighbours and 
//		we cannot move outside the boundary of the rectangle at any point of time.
//		Input :				Output:
//			 x = 2					NO
//			 y = 3
//			 N = 1
//			 R = 1
//			 A = [2]
//			 B = [3]
public class ValidPath {
	int[] dx = { 1, -1, 0, 0, 1, -1, -1, 1 };
	int[] dy = { 0, 0, 1, -1, 1, 1, -1, -1 };

	public String solve(int A, int B, int C, int D, int[] E, int[] F) {
		boolean[][] mat = new boolean[A + 1][B + 1];
		for (int i = 0; i <= A; i++) {
			for (int j = 0; j <= B; j++) {
				boolean flag = false;
				for (int k = 0; k < E.length; k++) {
					// if that point lies inside circle
					if (((E[k] - i) * (E[k] - i)) + (F[k] - j) * (F[k] - j) <= (D * D)) {
						flag = true;
						break;
					}
				}
				mat[i][j] = flag;
			}
		}
		if (mat[0][0] == true)
			return "NO";
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		mat[0][0] = true;
		while (!q.isEmpty()) {
			int[] point = q.poll();
			if (point[0] == A && point[1] == B)
				return "YES";
			// MOVE in all 8 directions
			for (int i = 0; i < 8; i++) {
				int new_x = dx[i] + point[0];
				int new_y = dy[i] + point[1];
				// if inside boundary and not inside of circle
				if (new_x >= 0 && new_y >= 0 && new_x <= A && new_y <= B && mat[new_x][new_y] == false) {
					q.add(new int[] { new_x, new_y });
					// make as visited
					mat[new_x][new_y] = true;
				}
			}
		}
		return "NO";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
