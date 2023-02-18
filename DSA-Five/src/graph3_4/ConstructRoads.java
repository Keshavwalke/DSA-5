package graph3_4;
//		A country consist of N cities connected by N - 1 roads. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//		King of that country want to construct maximum number of roads such that 
//		the new country formed remains bipartite country.
//		Bipartite country is a country, whose cities can be partitioned into 2 sets 
//		in such a way, that for each road (u, v) that belongs to the country, 
//		u and v belong to different sets. Also, there should be no multiple roads 
//		between two cities and no self loops.
//		Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.
//		NOTE: All cities can be visited from any city.
//		Input :				Output:
//			 A = 3					0
//			 B = [ [1, 2]
//			       [1, 3]]

public class ConstructRoads {
	public int solve(int A, int[][] B) {
		int N = B.length;
		ArrayList<Integer> arr[] = new ArrayList[A + 1]; // created adjlist initialized
		for (int i = 0; i <= A; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N; i++) {
			int a = B[i][0];
			int b = B[i][1]; // filled adjlist
			arr[a].add(b);
			arr[b].add(a);
		}

		int colour[] = new int[A + 1];
		Arrays.fill(colour, 0); // 0-no colour; 1-Green; 2-Blue

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		colour[1] = 1;
		while (q.size() > 0) {
			int u = q.poll();
			for (int j = 0; j < arr[u].size(); j++) {
				int v = arr[u].get(j);
				if (colour[v] == 0) {
					colour[v] = 3 - colour[u];
					q.add(v);
				}
			}
		}
		long Green = 0;
		long Blue = 0;
		for (int i = 1; i <= A; i++) {
			if (colour[i] == 1) {
				Green++;
			} else {
				Blue++;
			}
		}

		int m = 1000000007;
		long p = ((Green * Blue) - (A - 1)) % m;
		return (int) p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
