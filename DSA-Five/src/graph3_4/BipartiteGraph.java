package graph3_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//		Given a undirected graph having A nodes. A matrix B of size M x 2 is given 
//		which represents the edges such that there is an edge between B[i][0] and B[i][1].
//		Find whether the given graph is bipartite or not.
//		A graph is bipartite if we can split it's set of nodes into two independent subsets A and B 
//		such that every edge in the graph has one node in A and another node in B
//		Note:
//		There are no self-loops in the graph.
//		No multiple edges between two pair of vertices.
//		The graph may or may not be connected.
//		Nodes are Numbered from 0 to A-1.
//		Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
//		Input :									Output:
//		A = 3										0
//		B = [ [0, 1], [0, 2], [1, 2] ]
public class BipartiteGraph {
	public int solve(int A, int[][] B) {
		int N = B.length;
		ArrayList<Integer> arr[] = new ArrayList[A + 1]; // created adjlist

		for (int i = 0; i <= A; i++) {
			arr[i] = new ArrayList<Integer>(); // Initialized adjlist
		}
		for (int i = 0; i < N; i++) {
			int x = B[i][0];
			int y = B[i][1]; // Filled Adjlist
			arr[x].add(y);
			arr[y].add(x);
		}

		Queue<Integer> q = new LinkedList<>(); // Created Queue to store elements
		int colour[] = new int[A + 1];
		Arrays.fill(colour, 0); // 1-Green ; 2-Blue; 0-no colour
		for (int a = 1; a <= A; a++) { // edge case for all connected components
			if (colour[a] == 0) {
				colour[a] = 1; // coloured first node and pushed to Queue
				q.add(a);

				while (q.size() > 0) {
					int u = q.poll(); // took first element of queue
					for (int i = 0; i < arr[u].size(); i++) { // taking all elements directing from U node
						int v = arr[u].get(i);

						if (colour[v] == 0) { // If adjacent element is not coloured will colour it
							colour[v] = 3 - colour[u]; // what a gimmick wow
							q.add(v); // pushing that node to queue
						} else if (colour[u] == colour[v]) { // if adjacent elements have same colour will return 0
							return 0;
						}
					}
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
