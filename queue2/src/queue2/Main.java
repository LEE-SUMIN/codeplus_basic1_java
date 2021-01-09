package queue2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokenizer;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		try {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int k = Integer.parseInt(tokenizer.nextToken());
			for(int i = 0; i < n; i++) {
				queue.add(i + 1);
			}
			sb.append("<");
			while(!queue.isEmpty()) {
				for(int i = 0; i < k; i++) {
					if(i == k - 1) {
						sb.append(queue.poll()).append(", ");
					}
					else {
						queue.add(queue.poll());
					}
				}
				
			}
			sb.delete(sb.length() - 2, sb.length());
			sb.append(">");
			
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
