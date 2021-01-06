package stack2;

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
		Stack<String> stack = new Stack<>();
		
		try {
			int num = Integer.parseInt(br.readLine());
			for(int i = 0; i < num; i++) {
				String input = br.readLine() + "\n";
				for(int j = 0; j < input.length(); j++) {
					if(input.charAt(j) == ' ' || input.charAt(j) == '\n') {
						while(!stack.empty()) {
							sb.append(stack.pop());
						}
						sb.append(input.charAt(j));
					}
					else {
						stack.push(input.substring(j, j+1));
					}
				}
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
