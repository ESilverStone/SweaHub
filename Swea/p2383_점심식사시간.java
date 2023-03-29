import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p2383_점심식사시간 {
	
	public static List<int[]> posP;
	public static List<int[]> posE;
	public static int[] choose;
	public static int[] exit0;
	public static int[] exit1;
	public static int idx0;
	public static int idx1;
	public static int M;
	
	
	public static void cal() {
		
		idx0 = 0;
		idx1 = 0;
		
		// 일단 다 출구로 집합
		// 근데 자기가 몇초 걸렸는지 시간 측정하고 와라잉
		for(int i=0; i<M; i++) {
			
			// choose[M][0]에 본인이 선택한 출구 번호 저장되있음
			int[] extP = posE.get(choose[i]);	// 출구
			int[] perP = posP.get(i);	// 닝겐
		
			if(choose[i] == 0)
				exit0[idx0++] = Math.abs(extP[0] - perP[0]) + Math.abs(extP[1] - perP[1]);
			else 
				exit1[idx1++] = Math.abs(extP[0] - perP[0]) + Math.abs(extP[1] - perP[1]);
		}		
	}
	
	public static int down(int[] exit, int idx) {
		
		// 내려가는데 걸리는 시간
		int[] temp = posE.get(idx);
		int time = temp[2];			
		
		if(idx == 0) idx = idx0;
		else idx = idx1;
		
		int delay = 0;
		
		for(int i=3; i<idx; i++) {
			
			if(exit[i]==0) break;
			// 현재 사람의 시작 시간과 3턴전의 사람의 끝시간을 비교한다. 
			// 만약 아직 내려가지 않았다면, 딜레이된 정도를 측정한다.
			int bf3 = exit[i-3] + time + delay;
			
			// 아직 3사람 만석인 경우
			if(exit[i] < bf3) {
				delay += bf3 - exit[i];
			}
			// 다 내려간 경우
			else {
				delay = 0;
			}
		}
		if(idx!=0) 
			return exit[idx-1] + time + delay;	
		else return 10000;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			int N = sc.nextInt();	// 방의 크기
			
			// 사람들 좌표와 출구 좌표
			posP = new ArrayList<int[]>();
			posE = new ArrayList<int[]>();
			
			
			// 입력 > 0과 1과 그외 숫자를 구분해야한다. 
			for(int i=0; i<N; i++) {
				
				for(int j=0; j<N; j++) {
					int ipt = sc.nextInt();
										
					// 0이면 넘어가기
					if(ipt == 0) continue;
					
					// 1이면 사람 > 좌표 알아둬야함
					if(ipt == 1) {
						int[] temp = {i,j};
						posP.add(temp);
					} 
					// 그외의 숫자 > 출구
					else {
						int[] exit = {i,j,ipt};
						posE.add(exit);
					}	
				}
			}
			// 입력 끝
			
			M = posP.size();			// 사람 명수
			choose = new int[M];		// 선택에 따른 경우의 수가 들어갈 배열
										// [1]에는 도착 시간들어갈 거임
			
			int min = Integer.MAX_VALUE;
			
			// 비트마스킹으로 모든 경우의 수를 구하기
			for(int i=0; i<(1<<M); i++) {
				
				for(int j=0; j<M; j++) {
					
					if((i & (1<<j))>0) {
						choose[j] = 1;		// idx가 1인 출구 선택
					} else {
						choose[j] = 0;		// idx가 0인 출구 선택
					}
				}
				exit0 = new int[M];
				exit1 = new int[M];
				
				
				// 자~ 드가자~
				cal();
				// 애들 다 출구에 집합함.
				
				// 자~ 내려가자~
				int total = 0;
				int total1 = down(exit0, 0);
				int total2 = down(exit1, 1);
				
				if(total1 > total2) total = total1;
				else total = total2;
				
				if(min > total) {
					min = total;
				}
			}
			
			System.out.println("#"+(t+1)+" "+min);
			
		}
	}
}
