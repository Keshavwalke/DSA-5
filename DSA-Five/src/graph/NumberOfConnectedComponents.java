package graph;

import java.util.ArrayList;

public class NumberOfConnectedComponents {
	static DFS obj = new DFS();

	public static int solve(int N, int E, int u[], int v[]) {
		ArrayList<Integer> adjlist[] = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adjlist[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < E; i++) {
			adjlist[u[i]].add(v[i]);
		}

		boolean vis[] = new boolean[N + 1];
		int count = 0;
		for (int i = 0; i < N + 1; i++) {
			if (vis[i] == false) {
				obj.dfs(i, adjlist, vis);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int u[] = { 1, 2, 4, 4, 5 };
		int v[] = { 2, 4, 3, 5, 5 };
		int N = 5;
		int E = 5;
		System.out.println(solve(N, E, u, v));

	}

}
