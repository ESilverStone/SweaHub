import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1107_리모컨2 {
	public static char[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		
		arr = new char[K];
		
		for(int i=0; i<K; i++) {
			map.put(sc.next().charAt(0), true);	// 금지된 숫자를 map에 저장
		}
		
		// 100에서 출발하는 경우
		int min = Math.abs(N - 100);
		int saveNum = 0;
		// 500000 *2만큼 검사
		out :
		for(int i=0; i<=1000000; i++) {
			
			int cnt = Math.abs(N - i); // i에서 출발하는 경우

			
			char[] num = String.valueOf(i).toCharArray();	// i 사지분해
			
			for(int j=0; j<num.length; j++) {
				if(map.containsKey(num[j])) {
					continue out;
				}	
			}
			cnt += num.length;
			
			if(min > cnt) {
				min = cnt;
			}
		}
	
		int result = min;
		if(N==100) result = 0;
		
		System.out.println(result);
	}
}
