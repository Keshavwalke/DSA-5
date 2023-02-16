package graph;

import java.util.ArrayList;
import java.util.Arrays;
import graph.DFS;

public class DFS {
	public static boolean solve(int N, int E, int u[], int v[], int S, int D) {
		ArrayList<Integer> adjlist[] = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adjlist[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < E; i++) {
			adjlist[u[i]].add(v[i]);
		}

		boolean vis[] = new boolean[N + 1];
		Arrays.fill(vis, false);
		dfs(S, adjlist, vis);
		return vis[D];
	}

	public static void dfs(int x, ArrayList<Integer> adjlist[], boolean vis[]) {
		if (vis[x] == true)
			return;
		vis[x] = true;
		for (int i = 0; i < adjlist[x].size(); i++) {
			int y = adjlist[x].get(i);
			if (vis[y] == false) {
				dfs(y, adjlist, vis);

			}
		}
	}

	public static void main(String[] args) {
		int u[] = { 1, 2, 4, 4, 5 };
		int v[] = { 2, 4, 3, 5, 5 };
		int N = 5;
		int E = 4;
		int S = 3;
		int D = 1;
		System.out.println(solve(N, E, u, v, S, D));

	}

}
