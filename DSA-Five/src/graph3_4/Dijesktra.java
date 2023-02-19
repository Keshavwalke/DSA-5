package graph3_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//		Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
//		You have to find an integer array D of size A such that:
//		=> D[i] : Shortest distance form the C node to node i.
//		=> If node i is not reachable from C then -1.
//		Note:
//		There are no self-loops in the graph.No multiple edges between two pair of vertices.
//		The graph may or may not be connected.Nodes are numbered from 0 to A-1.
//		Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
//		Input :						Output:
//		A = 6							D = [7, 6, 5, 6, 0, 6]
//		B = [   [0, 4, 9]
//		        [3, 4, 6] 
//		        [1, 2, 1] 
//		        [2, 5, 1] 
//		        [2, 4, 5] 
//		        [0, 3, 7] 
//		        [0, 1, 1] 
//		        [4, 5, 7] 
//		        [0, 5, 1] ] 
//		C = 4
public class Dijesktra {
	public int[] solve(int A, int[][] B, int C) {
		int E = B.length; // Edges
		int N = A; // Nodes here nodes numbering is 0 to N-1

		ArrayList<Pair> arr[] = new ArrayList[N]; // created adjlist,intialized
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < E; i++) { // filled adjlist
			int startEdge = B[i][0];
			int endEdge = B[i][1]; // 0-1 ==edge 2-weight
			int weight = B[i][2];
			arr[startEdge].add(new Pair(endEdge, weight));
			arr[endEdge].add(new Pair(startEdge, weight));
		}
		int time[] = new int[N]; // Created time array, intialized with inifinity
		Arrays.fill(time, Integer.MAX_VALUE);
		time[C] = 0; // filled time of source equal to zero

		PriorityQueue<Pair> q = new PriorityQueue<Pair>(new paircomp()); // created minheap implements comparator
		q.add(new Pair(0, C)); // Pushed source time as zero

		while (q.size() > 0) {
			Pair ele = q.poll(); // removed top element
			int t = ele.first;
			int u = ele.second;

			if (t > time[u]) { // U is already blasted so will do nothing
				continue;
			} else {
				for (int i = 0; i < arr[u].size(); i++) {
					Pair ele2 = arr[u].get(i);
					int v = ele2.first;
					int w = ele2.second;
					if (time[v] > (time[u] + w)) { // if time from u to v is lesser than already time, updated time
						time[v] = time[u] + w;
						q.add(new Pair(time[v], v)); // Pudhed time, endEdge
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (time[i] == Integer.MAX_VALUE) { // if at all any node not reachable marked time -1;
				time[i] = -1;
			}
		}
		return time;
	}

	class Pair {
		int first;
		int second;

		Pair(int first, int second) { // created class pair and intialized constructor
			this.first = first;
			this.second = second;
		}
	}

	class paircomp implements Comparator<Pair> {
		public int compare(Pair p1, Pair p2) {
			if (p1.first < p2.first) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
