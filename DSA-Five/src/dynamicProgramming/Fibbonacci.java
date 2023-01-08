package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Fibbonacci {
	public static int solve(int A, int[] arr) {
		if (A <= 1) {
			return A; // Base Condition
		}
		if (arr[A] == -1) { // if array value is -1 means this is occurring for first time
			arr[A] = solve(A - 1, arr) + solve(A - 2, arr);
		}
		return arr[A]; // else already value available returning that value
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int arr[] = new int[A + 1];
		Arrays.fill(arr, -1); // using default method to fill the array

		System.out.println(solve(A, arr)); // Printing the result
		sc.close();
	}

}
