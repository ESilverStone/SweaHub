import java.util.Scanner;

public class p1486_장훈이의높은선반 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for(int t=0; t<T; t++) {
			
			int N = sc.nextInt();	// 점원수
			int h = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int result = Integer.MAX_VALUE;
			
			for(int i=1; i<(1<<N); i++) {
				
				int sum = 0;
				
				for(int j=0; j<N; j++) {
					if((i & (1<<j)) > 0) {
						
						sum += arr[j];
					}
					
				}
				
				if(result > sum && sum >= h) {
					result = sum;
				}
			}
			
			System.out.println("#"+(t+1)+" "+(result-h));
			
		}
		
		
	}
}
