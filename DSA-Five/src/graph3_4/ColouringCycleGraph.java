package graph3_4;

//		Given the number of vertices A in a Cyclic Graph.
//		Your task is to determine the minimum number of colors required to color the graph 
//		so that no two Adjacent vertices have the same color.
//		A cyclic graph with A vertices is a graph with A edges, 
//		such that it forms a loop. See example test case explanation for more details.
//		Input :				Output:
//			 5					3
public class ColouringCycleGraph {
	public int solve(int A) {
		if (A % 2 == 0) // if even means we can give alternate colour else 3 colours required
			return 2;
		return 3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
