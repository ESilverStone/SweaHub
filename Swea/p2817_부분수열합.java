import java.util.Scanner;

public class p2817_부분수열합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();	// 입력받는 수 개수
			int K = sc.nextInt();	// 만들어야하는 합
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 비트 머시기 한번 해보자
			// 전체 경우의 수
			int cnt = 0;
			int sum = 0;
			for(int i = 0 ; i<(1<<N); i++) {
				
	            for(int j=0; j<N; j++){
	                if((i & (1<<j)) > 0)	sum += arr[j];
	               
	                if(sum > K) break;
	            }             
	            if(sum == K) cnt++; 
	            sum = 0;
			}	
			System.out.println("#"+(t+1)+" "+cnt);	
		}
	}
}
