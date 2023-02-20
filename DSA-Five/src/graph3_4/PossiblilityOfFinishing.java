package graph3_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//	There are a total of A courses you have to take, labeled from 1 to A.
//	Some courses may have prerequisites, for example to take course 2 
//	you have to first take course 1, which is expressed as a pair: [1,2].
//	So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
//	Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//	Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
//	Input :					Output:
//		 A = 3					1
//		 B = [1, 2]
//		 C = [2, 3]

public class PossiblilityOfFinishing {
	public int solve(int A, int[] B, int[] C) {
		int E = B.length;

		ArrayList<Integer> arr[] = new ArrayList[A + 1];
		for (int i = 0; i <= A; i++) { // created adjlist, Initialized
			arr[i] = new ArrayList<Integer>();
		}

		int edge[] = new int[A + 1];
		Arrays.fill(edge, 0); // created edge count array, Initialized

		for (int i = 0; i < E; i++) {
			int a = B[i];
			int b = C[i]; // Filled adjlist and filled edge count array
			arr[a].add(b);
			edge[b] = edge[b] + 1;
		}

		int ind = 0;
		Queue<Integer> q = new LinkedList<>(); // created q to store 0 frequency elements
		for (int i = 1; i <= A; i++) {
			if (edge[i] == 0) { // filled elements having no prerequisite
				q.add(i);
			}
		}
		while (q.size() > 0) {
			int u = q.poll(); // Once one element done , elements depending on it will have frequency -1
			ind++;
			for (int j = 0; j < arr[u].size(); j++) {
				int v = arr[u].get(j);
				edge[v] = edge[v] - 1;
				if (edge[v] == 0) {
					q.add(v);
				}
			}
		}

		if (ind < A)
			return 0; // If not able to do all prerequisite this number will stay less than A
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
