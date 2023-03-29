import java.util.Scanner;

public class p1217_거듭제곱 {
	
	public static int cnt;
	public static int n;
	public static int m;
	
	public static int again(int result) {
		// 탈출 조건
		if(++cnt == m) return n;
		// 재귀
		return again(result) * n; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int t=0; t<T; t++) {
			
			int tc = sc.nextInt();
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			cnt = 0;	// 초기화
			int result = again(1);
			
			System.out.println("#"+tc+" "+ result);	
		}
	}
}
