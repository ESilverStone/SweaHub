import java.util.Scanner;

public class p2112_보호필름 {
	
	public static int[][] arr;
	public static int[][] copy;
	public static int[] save;
	public static int D,W,K;
	
	public static int[] A;
	public static int[] B;
	
	public static int min;	

	public static void func(int idx, int cnt) {
		
		if(cnt >= K || idx == D) {
		
			
			if(min>cnt && check()) min = cnt;
			return;
		}
	
		// 1. 노주입
		func(idx+1, cnt);
		
		// 2. 에이 주입
		inj(idx, 0);
		func(idx+1, cnt+1);
		
		// 3. 삐 주입
		inj(idx, 1);
		func(idx+1, cnt+1);
		
		// 원상 복구
		restore(idx);
	}
	
	// 복구
	public static void restore(int idx) {
		
		for(int i=0; i<W; i++) {
			arr[idx][i] = copy[idx][i];
		}
	}
	
	// 주입
	public static void inj(int idx, int k) {	
		
		if(k == 0)	{
			for(int i=0; i<W; i++) {
				arr[idx][i] = A[i];
			}
		}
		else {	
			for(int i=0; i<W; i++) {
				arr[idx][i] = B[i];
			}
		}
	}

	// 검사 메서드
	public static boolean check() {
		
		for(int j=0; j<W; j++) {
			
			int bfr = 2;	// 0,1이 아닌 값으로 초기화
			int cnt = 1;
			
			for(int i=0; i<D; i++) {
				
				if(bfr == arr[i][j]) cnt++;
				else {
					cnt = 1;			// 카운트 초기화
					bfr = arr[i][j];	// 다음을 위해 이전값 대체
				}	
				
				if(cnt == K) break;
			}		
			if(cnt < K) return false;	// 하나라도 실패면 false
		}
		return true;	// 모든 열에 대해 cnt >= K면  true	
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			
			A = new int[W];
			B = new int[W];
			
			for(int i=0; i<W; i++) {
				A[i] = 0;
				B[i] = 1;			
			}
			
			arr = new int[D][W];
			copy = new int[D][W];
			save = new int[W];
			
			for(int i=0; i<D; i++) {
				for(int j=0; j<W; j++) {
					
					arr[i][j] = sc.nextInt();
					copy[i][j] = arr[i][j];
				}
			}
			
			min = 100;
			func(0,0);

			System.out.println("#"+(t+1)+" "+min);
		}
	}
}
