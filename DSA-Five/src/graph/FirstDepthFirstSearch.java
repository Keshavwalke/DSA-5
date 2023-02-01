package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstDepthFirstSearch {
	public int solve(ArrayList<Integer> A, final int B, final int C) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(A.size()+1);
       
        for (int i = 0; i < A.size() + 1; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // Adjacency list
        for(int i=1; i<A.size(); i++){  
            adjList.get(A.get(i)).add(i+1);
        }
     
        // BFS

        Queue<Integer> queue = new LinkedList<Integer>();
        Boolean[] visted = new Boolean[A.size()+1];
        queue.add(C);
        visted[C]  = true;
        while(queue.size()>0){
            int u = queue.remove();
            for(int i=0; i<adjList.get(u).size();i++){
                int v = adjList.get(u).get(i);
                if(visted[v] == null){
                    queue.add(v);
                    visted[v] = true;
                }
            }
        }
       
        return visted[B] == null ? 0 : 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
