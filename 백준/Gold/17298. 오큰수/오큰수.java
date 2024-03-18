
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		
		// 입력 받기 위한 BufferedReader 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 구해진 오큰수 값이 저장될 스택
		Stack<Integer> result = new Stack<Integer>();
		
		// 오른쪽부터 순서대로 탐색한 원소들을 임시로 저장할 스택
		Stack<Integer> tmp = new Stack<Integer>();
		
		// 결과를 저장할 StringBuilder 객체 생성
		StringBuilder sb = new StringBuilder();
		
		// 수열의 크개를 입력 받음
		int n = Integer.parseInt(br.readLine());
		
		// 수열의 각 원소를 입력받아서 처리
		String[] input = br.readLine().split(" ");
		// 입력된 수열을 역순으로 우->좌로 탐색한다.
		for(int i = n-1; i >= 0; i--) {
			// 현재 원소를 정수형으로 변환하여 num에 저장한다.
			int num = Integer.parseInt(input[i]);
			// tmp 임시 스택이 비어있지 않고, 현재 원소가 tmp 스택의 맨 위 원소보다 크거나 같을 때까지 반복한다 현재 값보다 작은 값이 나올 때까지 tmp스택의 원소를 제거한다.
			while(!tmp.isEmpty() && (num >= tmp.peek())) {
				tmp.pop();
			}
			// tmp 스택이 비었다면 현재 원소의 오큰수가 없으므로 -1을 result 스택에 추가한다.
			if(tmp.isEmpty()) {
				result.add(-1);
			}else {		// 현재 값의 오큰수가 tmp 스택의 맨 위 원소이므로 result 스택에 추가한다
				result.add(tmp.peek());
			}
			tmp.add(num);	// 현재 원소를 tmp 스택에 추가한다.
		}
		
		// result 스택에서 원소를 꺼내고 StringBuilder에 담는 작업을 반복한다.
		while(!result.isEmpty()) {
			sb.append(result.pop() + " ");
		}
		// 최종적으로 stringBuilder에 담긴 결과를 출력한다.
		System.out.println(sb);
	}
}