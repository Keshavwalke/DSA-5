package graph3_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//		Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given 
//		which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
//		Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices 
//		such that for every directed edge uv, vertex u comes before v in the ordering.
//		Topological Sorting for a graph is not possible if the graph is not a DAG.
//		Return the topological ordering of the graph and if it doesn't exist then return an empty array.
//		If there is a solution return the correct ordering. 
//		If there are multiple solutions print the lexographically smallest one.
//		Ordering (a, b, c) is said to be lexographically smaller than ordering 
//		(e, f, g) if a < e or if(a==e) then b < f and so on.
//		Input :							Output:
//			 A = 6							[5, 6, 1, 3, 4, 2]
//			 B = [  [6, 3] 
//			        [6, 1] 
//			        [5, 1] 
//			        [5, 2] 
//			        [3, 4] 
//			        [4, 2] ]
public class TopologicalSort {
	public int[] solve(int A, int[][] B) {
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

		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 1; i <= A; i++) {
			if (inE[i] == 0) { // Filled edges having 0 dependency in queue
				q.add(i);
			}
		}

		int ans[] = new int[A]; // created ans array
		int ind = 0;

		while (q.size() > 0) {
			int u = q.poll(); // removing front element of queue each time
			ans[ind] = u;
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

		if (ind < A) {
			return new int[0];
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
