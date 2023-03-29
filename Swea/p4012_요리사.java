import java.util.Scanner;

public class p4012_요리사 {
	public static int[][] arr;
	public static int dog;
	public static int[] arr2;
	public static int min;
	
	public static void cal(int idx, int cnt) {
		
		if(cnt==dog) {
			sum();
			return;
		}
		
		if(idx == arr.length-1) return;
		
		// 선택하고 넘어가기
		arr2[idx] = 1;
		cal(idx+1, cnt+1);
		
		// 선택안하고 넘어가기
		arr2[idx] = 0;
		cal(idx+1, cnt);
	}
	
	public static void sum() {
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				
				if(arr2[i]==1 && arr2[j]==1) {
					sum1 += arr[i][j];
					sum1 += arr[j][i];
				} else if(arr2[i]==0 && arr2[j]==0){
					sum2 += arr[i][j];
					sum2 += arr[j][i];
				}
			}
		}
		//System.out.println(sum1+" "+sum2);
		int diff = Math.abs(sum1 - sum2);
		
		if(diff < min) {
			min = diff;
		}	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			arr = new int[N][N];
			arr2 = new int[N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			dog = N/2;
			// N개중 N/2를 선택하는 문제
			
			cal(0, 0);
			
			System.out.println("#"+(t+1)+" "+min/2);	
		}
	}
}
