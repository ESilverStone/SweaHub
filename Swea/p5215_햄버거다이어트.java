import java.util.Scanner;

public class p5215_햄버거다이어트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			int N = sc.nextInt();		// 재료 수
			int L = sc.nextInt();		// 칼로리 수
			int[][] arr = new int[N][2];	// 0 : 재료 맛, 1 : 칼로리
			
			for(int i=0; i<N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			int favor = 0;
			int cal = 0;
			int max = 0;
			
			// 비트 마스킹 재민네
			for(int i=0; i<(1<<N); i++) {
				
				for(int j=0; j<N; j++) {
					
					if((i & (1<<j)) > 0) {
						favor += arr[j][0];
						cal += arr[j][1];
					}
				}
				
				if(cal <= L) {
					if(max < favor) max = favor;
				}
				
				cal = 0;
				favor =0;
			}
			
			System.out.println("#"+(t+1)+" "+max);	
			
		}
	}
}	
