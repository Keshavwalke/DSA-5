package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//		Given an directed graph having A nodes labeled from 1 to A containing M edges 
//		given by matrix B of size M x 2such that there is a edge directed from node
//		B[i][0] to node B[i][1].
//		Find whether a path exists from node 1 to node A.
//		Return 1 if path exists else return 0.
//		Input:						
//		 A = 5						Output:
//		 B = [  [1, 2] 					0
//		        [4, 1] 
//		        [2, 4] 
//		        [3, 4] 
//		        [5, 2] 
//		        [1, 3] ]

public class PathInDirectedGraph {
	public static int solve(int A, int[][] B) {
		int M = B.length;
		ArrayList<Integer>[] arr = new ArrayList[A + 1]; // created adjlist
		for (int i = 0; i <= A; i++) {
			arr[i] = new ArrayList<Integer>(); // Initialized
		}

		for (int i = 0; i < M; i++) {
			int a = B[i][0]; // filled adjlist values as it is directed only took from a to b
			int b = B[i][1];
			arr[a].add(b);
		}

		boolean vis[] = new boolean[A + 1]; // created boolean array to store visited
		Arrays.fill(vis, Boolean.FALSE); // Initialized
		
		int level[]=new int[A+1];
		Arrays.fill(level, -1);				//Level array for calculating min path length
		level[1]=0;
		
		int parent[]=new int[A+1];
		Arrays.fill(parent, -1);
		
		Queue<Integer> q = new LinkedList<>(); // created q for storing nodes just like level order
		q.add(1); // adding initial element

		while (q.size() > 0) {
			int x = q.remove(); // removing first element
			for (int i = 0; i < arr[x].size(); i++) { // for that list iterating
				int y = arr[x].get(i);
				if (vis[y] == false) { // checking this node already visited or not
					q.add(y); // if not then adding in queue and marking as visited
					vis[y] = true;
					level[y]=level[x]+1;	// Storing level of element
					parent[y]=x;		//storing the parent of element
				}
			}
		}
		System.out.println(level[A]);		//It'll tell directly what is level of destination from source
		
		ArrayList<Integer> path=new ArrayList<>();
		int p=A;
		while(p!=-1) {
			path.add(p);					//adding parent elements in the list
			p=parent[p];
		}
		
		System.out.println(path);			//Printing the path list
		
		if (vis[A] == true)
			return 1; // If visited of A is marked true then path possible
		return 0;
	}

	public static void main(String[] args) {
		int A = 5;
		int B[][] = { {1, 2}, {2, 4},{4, 3},{3, 5}};
		System.out.println(solve(A, B));

	}

}
