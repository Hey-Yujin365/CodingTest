package mentoring;

import java.io.*;
import java.util.Stack;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	// �Է��� ���� BufferedReader ��
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// �Ź� systemout�� �ƴ϶� �ѹ��� ��Ƽ� ����ϱ� ���� StringBuilder ����
    	StringBuilder sb = new StringBuilder();
    	
    	// ������ ���̸� ��Ÿ���� ���� n�� �Է¹���
    	int n = Integer.parseInt(br.readLine());
    	
    	// ���� ����
    	Stack<Integer> stack = new Stack<Integer>();
    		
    	// ���ÿ� ���� ���� ���� (1���� ����)
    	int start = 1;
    	
    	// ������ �� ���Ҹ� �Է¹ް� ó���ϴ� �ݺ��۾�
    	for (int i = 0; i < n; i++) {
    		
    		int value = Integer.parseInt(br.readLine());	// ���� �Է�
    		
    		// �Էµ� ���ڰ� ���� ���ں��� ũ�ų� ���� ���
    		if (start <= value) {
    			// start���� �Էµ� ���ڱ��� ���ÿ� push�Ͽ� �ùٸ� ������ ����� �ݺ��۾�
    			for (int num = start; num <= value; num++) {
    				// stack�� push
    				stack.push(num);
    				// push�� ��ŭ "+"�� StringBuilder�� �߰�
    				sb.append('+').append('\n');
    			}
    			// value���� ó�������� ���� ���ں��� �ٽ� push �غ��ϱ� ���� start�� value + 1 ���� �־��ش�.
    			start = value + 1;
    		}
    		// ������ �� �� ���ڿ� �Էµ� ���ڰ� �ٸ� ��� (�ùٸ� ������ ���� �� ����)
    		else if (stack.peek() != value) {
    			System.out.println("NO");
    			System.exit(0);
    		}
    		
    		// ������ �� �� ���ڿ� �Էµ� ���ڰ� ���� ���
    		stack.pop();	// ���ÿ��� ���ڸ� pop�Ͽ� �ùٸ� ������ �����
    		sb.append('-').append('\n');	// "-"�� StringBuilder�� �߰�
    	}
    	
    	// ��� ���
    	System.out.println(sb);
    }
}