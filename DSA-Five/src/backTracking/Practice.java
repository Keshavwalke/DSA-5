package backTracking;

public class Practice {
	public static void solve(int[]arr,int A, int N) {
		if(A==N) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+"next ");
			}
			return;
		}
		arr[A]=1;
		solve(arr,A+1,N);
		arr[A]=2;
		solve(arr,A-1,N);
	}

	public static void main(String[] args) {
		int arr[]= {0,1,0};
		int A=0;
		int N=3;
	//	System.out.println(arr);
		solve(arr,A,N);

	}

}
