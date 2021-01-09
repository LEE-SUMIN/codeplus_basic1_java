package stack7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
		int result = 0;
		String input;
		
		try {
			input = br.readLine();
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == '(') {
					stack.push(i);
				}
				else {
					if(stack.pop() == i - 1) {
						result += stack.size();
					}
					else {
						result++;
					}
				}
			}
			System.out.println(result);
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
