package stack5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();
		StringTokenizer tokenizer;
		
		try {
			String input = br.readLine();
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < input.length(); i++) {
				left.push(input.substring(i, i+1));
			}
			while(N --> 0) {
				tokenizer = new StringTokenizer(br.readLine());
				String inst = tokenizer.nextToken();
				if(inst.equals("P")) {
					String val = tokenizer.nextToken();
					left.push(val);
				}
				else if(inst.equals("L")) {
					if(!left.isEmpty()) {
						right.push(left.pop());
					}
				}
				else if(inst.equals("D")) {
					if(!right.isEmpty()) {
						left.push(right.pop());
					}
				}
				else if(inst.equals("B")) {
					if(!left.isEmpty()) {
						left.pop();
					}
				}
			}
			while(!left.isEmpty()) {
				right.push(left.pop());
			}
			while(!right.isEmpty()) {
				sb.append(right.pop());
			}
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
