package stack6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		boolean tag = false;
		
		String input;
		try {
			input = br.readLine();
			for(int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if(ch == '<') {
					tag = true;
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(ch);
				}
				else if(ch == '>') {
					tag = false;
					sb.append(ch);
				}
				else if(tag) { //tag내부
					sb.append(ch);
				}
				else if(!tag && ch == ' ') { //tag외부 단어 구분
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(' ');
				}
				else { //tag외부
					stack.push(ch);
				}
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
