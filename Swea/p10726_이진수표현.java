import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p10726_이진수표현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			Queue<Integer> que = new LinkedList<>();
			
			// M을 이진수로 표현 후 N만큼 검사
			while(M!=0 && M!=1) {
				que.add(M%2);
				M/=2;
			}
			que.add(M);	// 마무리 값도 저장
			
			boolean isWrong = false;
			
			if(N > que.size()) isWrong = true;
			
			for(int j=0; j<N; j++) {
				
				if(!que.isEmpty() && que.poll() == 0) {
					isWrong = true;
					break;
				}
			}
			
			if(isWrong) System.out.println("#"+(t+1)+" OFF");
			else 		System.out.println("#"+(t+1)+" ON");
		}
	}
}
