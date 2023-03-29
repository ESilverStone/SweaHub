import java.util.Scanner;

public class p2105_디저트카페 {
	
	public static void cal() {
		// 직진 or 좌회전
		// 단, 직진 시 벽에 박으면 자동으로 좌회전하면서 벡터 방향 전환
		
		// 먼저 재귀로 직진의 경우를 보고 성공하면 해당 좌표에서의 좌회전의 경우를 봉인
		
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 입력 끝
			
			
			
			
			
		}
		
		
	}
}
