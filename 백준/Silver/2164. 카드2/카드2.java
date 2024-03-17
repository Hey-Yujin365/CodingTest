import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	// bufferReader를 생성한다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        // 버퍼로 입력받은 값을 integer로 변환해서 담는다.
        // 참고로 버퍼리더는 입력 받은 값이 string 형식으로 고정이기 때문에 parseInt를 통해 integer형식으로 변환해준다.
        int n = Integer.parseInt(bf.readLine());
        
        // Queue는 인터페이스기 때문에 구현체인 linkedList로 queue를 정의해준다.
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // 1부터 입력받은 숫자 n까지 차례대로 큐에 넣어준다.
        for (int i = 1; i<= n; i++) {
        	queue.add(i);
        }
        
        // 큐에 마지막에 담긴 숫자를 구하는 것이므로 큐 사이즈가 1보다 클 때까지만 반복하는 반복문을 만들어준다.
        while(queue.size() > 1) {
        	// 가장 front에 있는 숫자를 꺼낸다.
        	queue.poll();
        	
        	// 또 다시 front에 있는 숫자를 꺼내서 맨 뒤로 보낼 변수 newLastNum에 담는다.
        	int newLastNum = queue.poll();
        	
        	// 큐에 방금 꺼냈던 맨 앞 숫자를 rear위치에 add한다.
        	queue.add(newLastNum);
        }
        // 마지막으로 큐에 하나 남아있는 숫자를 꺼내서 출력한다.
        System.out.println(queue.poll());
        
        // 메모리 누수 방지를 위해 BufferReader 끝낸다.
        bf.close();
    }
}