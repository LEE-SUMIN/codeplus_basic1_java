package stack4;

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
		Stack<Integer> stack = new Stack<>();
		int top = 0;
		
		try {
				int num = Integer.parseInt(br.readLine());
				while(num-- > 0) {
					int value = Integer.parseInt(br.readLine());
					if(value > top) {
						while(top != value) {
							top++;
							stack.push(top);
							sb.append("+\n");
						}
					}
					else if(value != stack.peek()) {
						sb.delete(0, sb.length());
						sb.append("NO");
						break;
					}
					stack.pop();
					sb.append("-\n");
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