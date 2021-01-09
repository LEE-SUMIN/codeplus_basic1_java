package stack9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
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
				tokenizer = new StringTokenizer(br.readLine());
				int[] arr = new int[N];
				int[] result = new int[N];
				HashMap<Integer, Integer> freq = new HashMap<>();
				
				for(int i = 0; i < N; i++) {
					arr[i] = Integer.parseInt(tokenizer.nextToken());
					freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
				}
				
				for(int i = 0; i < N; i++) {
					if(stack.isEmpty()) {
						stack.push(i);
					}
					else {
						while(!stack.isEmpty() && freq.get(arr[stack.peek()]) < freq.get(arr[i])) {
							result[stack.pop()] = arr[i];
						}
						stack.push(i);
					}
				}
				
				while(!stack.isEmpty()) {
					result[stack.pop()] = -1;
				}
				
				for(int i = 0; i < N; i++) {
					sb.append(result[i]).append(' ');
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
