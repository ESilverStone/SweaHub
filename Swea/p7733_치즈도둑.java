import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class p7733_치즈도둑 {
	public static int N;
	public static int max;
	public static int cnt;
	public static int max_ipt;
	
	public static int[][] arr;
	public static boolean[][] visit;
	public static boolean[][] check;
	public static Map<Integer, Boolean> map;
	public static Stack<int[]> st;
	
	public static void controller(int day) {
		
		// 굳이 100일까지 안돌고 최대까지만 돌아도 된다. 
		if(day > max_ipt) return;
		
		// 생쥐로 의심되는 요정의 점심시간
		yamYam(day);
		
		check = new boolean[N][N];
		visit = new boolean[N][N];
		// 스택은 dfs 돌때마다 초기화 되어야하므로 여기서 선언해준다. 
		st = new Stack<>();
		cnt = 0;
		
		// 해당 일자에 dfs 검사
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 0이 아닌 경우만 dfs 돌릴 수 있다.
				if(arr[i][j] != 0) dfs(i, j);			
			}
		}
		// 최대값 비교
		if(max < cnt) max = cnt;
		
		// 다음 재귀
		controller(day+1);
	}

	// 순서 우, 하, 좌, 상
	static int[] vi = {0,1,0,-1};
	static int[] vj = {1,0,-1,0};
	
	public static void dfs(int i, int j) {
		
		// 이미 해당 영역은 dfs를 돌려져버렸다 > 아웃
		if(check[i][j]) return;	
		
		int[] temp = {i,j};
		st.add(temp);
		visit[i][j] = true;
		
		// 스택이 비어있는 순간 종료
		while(!st.isEmpty()) {
			// 정점을 하나 꺼낸다. 
			int[] curr = st.pop();
			
			// 나와 연결되어 있으면서 방문하지 않은 친구들을 st에 넣는다. 
			for(int v=0; v<4; v++) {
				int setI = curr[0] + vi[v];
				int setJ = curr[1] + vj[v];
				
				// 배열 밖을 넘어가는 경우
				if(setI<0 || setJ<0 || setI>=N || setJ>=N) continue;
				
				// 0인 경우
				if(arr[setI][setJ] == 0) continue;
				
				int[] nxt = {setI, setJ};
				
				// 이미 방문했는지? 
				if(!visit[setI][setJ]) {
					st.add(nxt);
					visit[setI][setJ] = true;
					check[setI][setJ] = true;		
				}
			}	
		}
		//dfs가 끝나면 한 덩어리가 나오니까 카운팅
		cnt++;
	}
		
	public static void yamYam(int day) {
		// 포함되어 있지 않았으면 굳이 탐색할 필요없다. 
		if(!map.containsKey(day)) return;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 날짜와 같은 치즈 0으로 변경
				if(arr[i][j] == day) arr[i][j] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	// 테스트 케이스
		
		for(int t=0; t<T; t++) {
			
			
			N = sc.nextInt();	// 치즈 한변의 길이
			arr = new int[N][N];
			
			map = new HashMap<Integer, Boolean>();
			
			max_ipt = Integer.MIN_VALUE;
			
			// 입력
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int ipt = sc.nextInt();
					
					arr[i][j] = ipt;
					
					if(max_ipt < ipt) max_ipt = ipt;
					
					if(map.containsKey(ipt)) continue;
					
					map.put(ipt, true);
				}
			}
			
			max = Integer.MIN_VALUE;
			
			controller(0);
			
			System.out.println("#"+(t+1)+" "+max);
		}
	}
}
