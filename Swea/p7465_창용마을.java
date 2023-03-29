import java.util.Arrays;
import java.util.Scanner;

public class p7465_창용마을 {
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			int N = sc.nextInt();	// 사람 수
			int M = sc.nextInt();	// 간선 수
			int[][] line = new int[M][2];
			
			p = new int[N];
			
			// 간선 입력
			for(int i=0; i<M; i++) {
				line[i][0] = sc.nextInt()-1;
				line[i][1] = sc.nextInt()-1;
			}
			
			// makeset
			for(int i=0; i<N; i++) {
				makeset(i);
			}
			
			for(int i=0; i<M; i++) {
				
				int px = findset(line[i][0]);
				int py = findset(line[i][1]);
				
				if(px != py) union(px, py);
			}
			
			for(int i=0; i<N; i++) findset(i);
			
			Arrays.sort(p);
			int cnt = 1;
			int back = p[0];
			
			for(int i=1; i<N; i++) {
				if(back != p[i]) cnt++;
				
				back = p[i];
			}
			
			System.out.println("#"+(t+1)+" "+cnt);
			
		}
	}
	
	
	static void makeset(int x) {
		p[x] = x;
	}
	
	static int findset(int x) {
		// path compression
		if(x != p[x]) p[x] = findset(p[x]);
	
		return p[x];
	}
	
	
	static void union(int x, int y) {
		p[y] = x;	// x 밑에 y
	}
	
}
