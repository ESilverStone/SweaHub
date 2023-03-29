import java.util.Scanner;

public class p1107_리모컨 {
	public static int cnt1;
	public static int cnt2;
	public static char[] arr;
	
	public static boolean check(int num) {
		String str = String.valueOf(num);
		if(num == 0) return true;
		
		//Out:
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			for(int j=0; j<arr.length; j++) {
				
				if(arr[j] == ch) {
					return false;
					
				}
			}
		}
		return true;
	}
	
	public static int upper(int num) {
		// 올려
		while(true) {
			if(check(num)) break;
			num++;
			cnt1++;
		}
		return cnt1;		
	}
	
	public static int upper9(int num) {
		// 올려
		while(true) {
			if(cnt1 > 99) break;
			if(check(num)) break;
			num++;
			cnt1++;
			//System.out.println(cnt1);
		}
		return cnt1;		
	}
	
	public static int lower(int num) {
		
		while(true) {
			if(check(num)) break;
			num--;
			cnt2++;
			//System.out.println(cnt2);
		}
		return cnt2;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		int K = sc.nextInt();
		arr = new char[K];
		
		for(int i=0; i<K; i++) {
			arr[i] = sc.next().charAt(0);		
		}
		
		int num = N;
		cnt1 = 0;

		if(K==9) 	cnt1 = upper9(num);
		else 		cnt1 = upper(num);
			
		//System.out.println(cnt1);
		
		num = N;
		cnt2 = 0;
		cnt2 = lower(num);
		
		
		int s1 = N-cnt1;
		int s2 = cnt2+N;
		
		int c1 = 1;
		int c2 = 1;
		
		// 자리수 구하기
		while(s1>10) {s1 /= 10; c1++;}
		while(s2>10) {s2 /= 10; c2++;}
		
		int result = (c1+cnt1>cnt2+c2)?cnt2+c2:cnt1+c1;
		
		if(N==100) 	result = 0;
		
		//System.out.println(c);
		
		System.out.println(result);	
	}
}
