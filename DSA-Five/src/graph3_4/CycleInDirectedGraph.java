package graph3_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//		Given an directed graph having A nodes. A matrix B of size M x 2 is given 
//		which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
//		Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
//		NOTE:
//		The cycle must contain atleast two nodes.
//		There are no self-loops in the graph.
//		There are no multiple edges between two nodes.
//		The graph may or may not be connected.
//		Nodes are numbered from 1 to A.
//		Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
//		Input :							Output:
//			 A = 5							1
//			 B = [  [1, 2] 
//			        [4, 1] 
//			        [2, 4] 
//			        [3, 4] 
//			        [5, 2] 
//			        [1, 3] ]
public class CycleInDirectedGraph {
	public int solve(int A, int[][] B) {
		int E = B.length; // Edges
		int inE[] = new int[A + 1]; // created edges count array,initialized with 0
		Arrays.fill(inE, 0);
		ArrayList<Integer> arr[] = new ArrayList[A + 1]; // created adjList and initialized
		for (int i = 0; i <= A; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < E; i++) {
			int x = B[i][0];
			int y = B[i][1]; // filled adjList
			arr[x].add(y);
			inE[y] = inE[y] + 1;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= A; i++) {
			if (inE[i] == 0) { // Filled edges having 0 dependency in queue
				q.add(i);
			}
		}

		int ind = 0;

		while (q.size() > 0) {
			int u = q.poll(); // removing front element of queue each time
			ind++;
			for (int j = 0; j < arr[u].size(); j++) { // iterating over element for that adjList and decreasing there
														// frequency by 1
				int v = arr[u].get(j);
				inE[v] = inE[v] - 1;
				if (inE[v] == 0) {
					q.add(v);
				}
			}
		}
		if (ind == A)
			return 0;
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
