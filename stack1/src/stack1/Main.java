package stack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer tokenizer;
			StringBuilder sb = new StringBuilder();
			Stack s = new Stack();
			int num = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < num; i++) {
				tokenizer = new StringTokenizer(br.readLine());
				String inst = tokenizer.nextToken();
				if(inst.equals("push")) {
					int item = Integer.parseInt(tokenizer.nextToken());
					s.push(item);
				}
				else if(inst.equals("top")) {
					sb.append(s.top()).append("\n");
				}
				else if(inst.equals("pop")) {
					sb.append(s.pop()).append("\n");
				}
				else if(inst.equals("empty")) {
					sb.append(s.empty()).append("\n");
				}
				else if(inst.equals("size")) {
					sb.append(s.size()).append("\n");
				}
			}
			
			if(sb.charAt(sb.length() - 1) == '\n') {
				sb.deleteCharAt(sb.length() - 1);
			}
			
			System.out.println(sb);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

class Stack {
	private ArrayList<Integer> stack = new ArrayList<Integer>();
	int size = 0;
	Stack(){ }
	
	public void push(int num) {
		stack.add(num);
		size++;
	}
	
	public int pop() {
		if(size == 0)
			return -1;
		else {
			size--;
			int data = stack.get(size);
			stack.remove(size);
			return data;
		}
	}
	
	public int size() {
		return size;
	}
	
	public int empty() {
		if(size == 0)
			return 1;
		else
			return 0;
	}
	
	public int top() {
		if(size == 0)
			return -1;
		else
			return stack.get(size - 1);
	}
	
}
