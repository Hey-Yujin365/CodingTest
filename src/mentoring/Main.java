package mentoring;

import java.io.*;
import java.util.Stack;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	// 입력을 위해 BufferedReader 생
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 매번 systemout이 아니라 한번에 모아서 출력하기 위해 StringBuilder 생성
    	StringBuilder sb = new StringBuilder();
    	
    	// 수열의 길이를 나타내는 변수 n을 입력받음
    	int n = Integer.parseInt(br.readLine());
    	
    	// 스택 생성
    	Stack<Integer> stack = new Stack<Integer>();
    		
    	// 스택에 넣을 시작 숫자 (1부터 시작)
    	int start = 1;
    	
    	// 수열의 각 원소를 입력받고 처리하는 반복작업
    	for (int i = 0; i < n; i++) {
    		
    		int value = Integer.parseInt(br.readLine());	// 숫자 입력
    		
    		// 입력된 숫자가 시작 숫자보다 크거나 같은 경우
    		if (start <= value) {
    			// start부터 입력된 숫자까지 스택에 push하여 올바른 수열을 만드는 반복작업
    			for (int num = start; num <= value; num++) {
    				// stack에 push
    				stack.push(num);
    				// push한 만큼 "+"를 StringBuilder에 추가
    				sb.append('+').append('\n');
    			}
    			// value까지 처리했으니 다음 숫자부터 다시 push 준비하기 위해 start에 value + 1 값을 넣어준다.
    			start = value + 1;
    		}
    		// 스택의 맨 위 숫자와 입력된 숫자가 다른 경우 (올바른 수열을 만들 수 없음)
    		else if (stack.peek() != value) {
    			System.out.println("NO");
    			System.exit(0);
    		}
    		
    		// 스택의 맨 위 숫자와 입력된 숫자가 같은 경우
    		stack.pop();	// 스택에서 숫자를 pop하여 올바른 수열을 만들기
    		sb.append('-').append('\n');	// "-"를 StringBuilder에 추가
    	}
    	
    	// 결과 출력
    	System.out.println(sb);
    }
}