import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test_보물상자비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		// 상자는 항상 4각형이다. 
		// 따라서, 한 변에 숫자가 최소 2개부터 7개다. 
		// 한 변에 숫자가 3개라면 3회전시 원래 숫자로 돌아온다. 
		// 한 변에 N개의 숫자 > N회전시 그대로
		
		for(int t=0; t<T; t++) {
			
			int N = sc.nextInt();	// 숫자의 개수
			int K = sc.nextInt(); 	// K번째로 큰 수를 찾자.
			int dog = N / 4; 		// 한 변의 숫자 개수
			
			// 입력이 한줄로 주어진다. > 숫자와 문자가 섞여있다. 
			// arr배열의 크기는 N이다. 
			char[] arr = sc.next().toCharArray(); 
			int[] arr2 = new int[N];
			
			// arr배열을 char에서 int로 변환 16진수 > 10진수
			// 0 - 48 > 0
			// a - 65 > 10
			for(int i=0; i<N; i++) {
				if('0' <= arr[i] && arr[i] <= '9') {	// 숫자
					arr2[i] = arr[i] - '0';
				} else {								// 알파벳
					arr2[i] = arr[i] - 55;
				}
			}
			// 배열을 dog의 크기 만큼 차례로 뽑아서 어딘가에 보관
			// 만약 contains로 이전에 저장된 값이면 건너뛴다. 
			// 저장할 때 그냥 16진수로 바꿔서 저장한다. 다른 형태면 무조건 중복되지 않기 때문이다. 
			// 그러면 우선 순위 큐에 보관한 후 k번 만큼 뽑아내자
			
			// 가능한 조합을 우선순위큐(리버스)에 넣은 후 빼낼 것
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			// arr배열에서 숫자 추출 > 가능한 최대 조합 수 N
			for(int i=0; i<N; i++) {
				
				int sum = 0;
				for(int j=0; j<dog; j++) {
					int idx = (i+j) % N;
					
					sum += (arr2[idx] * Math.pow(16, dog-1-j));
				}
				if(!pq.contains(sum)) pq.add(sum);
			}
			
			int result = 0;
			// k번째로 큰 수?
			for(int i=0; i<K; i++) {
				if(!pq.isEmpty()) result = pq.poll();
			}
			
			System.out.println("#"+(t+1)+" "+result);
		}
	}
}
