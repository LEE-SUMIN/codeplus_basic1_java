package math5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokenizer;
		
		try {
			tokenizer = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(tokenizer.nextToken());
			int n = Integer.parseInt(tokenizer.nextToken());
			boolean[] check = new boolean[n + 1];
			
			check[0] = check[1] = true;
			
			for(int i = 2; i * i <= n; i++) {
				if(!check[i]) {
					for(int j = i * i; j <= n; j += i) {
						check[j] = true;
					}
				}
			}
			
			for(int i = m; i <= n; i++) {
				if(check[i] == false) {
					sb.append(i).append('\n');
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
