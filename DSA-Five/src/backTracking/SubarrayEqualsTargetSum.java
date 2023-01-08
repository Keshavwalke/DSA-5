package backTracking;

//Given array of size N, count number of subsets with sum==target

public class SubarrayEqualsTargetSum {
	public static int solve(int arr[], int i, int N, int target, int sum) {
		if (i == N) {
			if (sum == target)
				return 1;
			else
				return 0;
		}
		sum = sum + arr[i]; // Picking element
		int c1 = solve(arr, i + 1, N, target, sum);
		sum = sum - arr[i]; // Leaving element
		int c2 = solve(arr, i + 1, N, target, sum);
		return c1 + c2;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 7, 2 };
		System.out.println(solve(arr, 0, 3, 7, 0));
	}

}
