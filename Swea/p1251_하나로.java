import java.util.Scanner;

public class p1251_하나로 {
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			int N = sc.nextInt();
			int[][] pos = new int[N][2];
			
			// x좌표
			for(int i=0; i<N; i++) pos[i][0] = sc.nextInt();
	
			// y좌표
			for(int i=0; i<N; i++) pos[i][1] = sc.nextInt();
			
			// 환경 부담 세율
			float e = sc.nextFloat();
	
			// 간선 입력
			// 간선의 개수는 nC2이다. 
			int dog = (N*(N-1))/2;
			int[][] lines = new int[dog][2];
			
			
			
			
		}
	}
}
