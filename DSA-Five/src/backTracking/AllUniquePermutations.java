package backTracking;

import java.util.ArrayList;
import java.util.Arrays;

//		Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
//		NOTE: No 2 entries in the permutation sequence should be the same.
//		Input :
//		A = [1, 1, 2]
//		
//		Output :
//			[ [1,1,2]
//			  [1,2,1]
//			  [2,1,1] ]
public class AllUniquePermutations {
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); // creating 2D arraylist
		getpermute(res, A, 0); // running helper function to fill values
		return res;
	}

	public static void getpermute(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A, int index) {
		if (index == A.size()) { // base condition if we are at last index
			if (!res.contains(A)) {
				res.add(new ArrayList<>(A)); // and this list is not there in arraylist then only add
			}
			return;
		}

		for (int i = index; i < A.size(); i++) { // going from i to N
			swap(A, i, index);
			getpermute(res, A, index + 1);
			swap(A, index, i);
		}
	}

	public static void swap(ArrayList<Integer> A, int i, int j) {
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1));
		System.out.println(permute(A));

	}

}
