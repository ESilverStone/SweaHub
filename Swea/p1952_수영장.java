import java.util.Scanner;

public class p1952_수영장 {
	public static int[] prc;
	public static int[] plan;
	public static int min;
	
	public static void dfs(int mon, int cost) {
		// 13월 아웃
		if(mon > 11) {	
			if(min > cost) min = cost;	
			return;
		}
			
		// 해당 달에 어떤 정기권을 사용할 것인가..?
		// 1. 1일권 사용 > 이왕 1일권 썼으면 한달 내내 써야됨
		dfs(mon+1, cost+prc[0]*plan[mon]);
		
		// 2. 1달권 사용
		dfs(mon+1, cost+prc[1]);
		
		// 3. 3달권 사용
		dfs(mon+3, cost+prc[2]);	
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			// 1일 / 1달 / 3달 / 1년
			prc = new int[4];
			
			for(int i=0; i<4; i++) {
				prc[i] = sc.nextInt();
			}
			
			// 1년 계획표
			plan = new int[12];
			
			for(int i=0; i<12; i++) {
				plan[i] = sc.nextInt();
			}
			
			// default 값을 1년짜리로 설정
			min = prc[3];
			
			dfs(0,0);
			
			System.out.println("#"+(t+1)+" "+min);	
		}
	}
}
