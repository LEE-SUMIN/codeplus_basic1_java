package stack8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokenizer;
		Stack<Integer> stack = new Stack<>();
		
		try {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			ArrayList<Integer> result = new ArrayList<>(N);
			tokenizer = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(tokenizer.nextToken()));
				result.add(0);
			}
			
			for(int i = 0; i < N; i++) {
				if(stack.isEmpty()) {
					stack.push(i);
				}
				else {
					while(!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i)) {
						result.set(stack.pop(), arr.get(i));
					}
					stack.push(i);
				}
			}
			
			while(!stack.isEmpty()) {
				result.set(stack.pop(), -1);
			}
			
			for(int i = 0; i < N; i++) {
				sb.append(result.get(i)).append(' ');
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
