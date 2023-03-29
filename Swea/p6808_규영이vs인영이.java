
import java.util.Scanner;

public class p6808_규영이vs인영이 {

	public static int[] arr1;
	public static int[] arr2;
	
	public static int[] check;
	
	public static int score1;
	public static int score2;
	public static int player1;
	public static int player2;
	
	public static void cal(int cnt) {

		if(cnt == 9) {
			if(score1 > score2) 		player1++;
			else if(score1 < score2)  	player2++;

			return;
		}
		
		int num1 = arr1[cnt];	// 해당 cnt에서 기준이될 player1의 숫자
		
		for(int i=0; i<9; i++) {
			
			if(check[i] == 1) continue;
			
			int sum = arr2[i] + num1;
			
			if(num1 < arr2[i]) 	score2 += sum;
			else 				score1 += sum;
			
			check[i] = 1;
			cal(cnt+1);
			check[i] = 0;						// 초기화 시작
			
			if(num1 < arr2[i]) 	score2 -= sum;
			else 				score1 -= sum;
			
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();

		for(int t=0; t<T; t++) {
			
			arr1 = new int[9];
			arr2 = new int[9];
			check = new int[9];
			int[] arr18 = new int[19];
			
			// player1 입력
			for(int i=0; i<9; i++) {
				arr1[i] = sc.nextInt();
				arr18[arr1[i]] = 1;		// player1 체크해두기
			}
			
			int idx2 = 0;
			
			// player2 입력
			for(int i=1; i<=18; i++) {
				if(arr18[i] == 1) continue;
				
				arr2[idx2] = i;
				idx2++;
			}
			
			player1 = 0;
			player2 = 0;
			
			cal(0);
			
			System.out.println("#"+(t+1)+" "+player1+" "+player2);	
		}
	}
}
