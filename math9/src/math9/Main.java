package math9;

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
			int N = Integer.parseInt(br.readLine());
			
			while(N --> 0) {
				tokenizer = new StringTokenizer(br.readLine());
				
				int K = Integer.parseInt(tokenizer.nextToken());
				int[] arr = new int[K];
				long sum = 0;
				
				for(int i = 0; i < K; i++) {
					arr[i] = Integer.parseInt(tokenizer.nextToken());
				}
				
				for(int i = 0; i < K - 1; i++) {
					for(int j = i + 1; j < K; j++) {
						sum += calc_gcd(arr[i], arr[j]);
					}
				}
				sb.append(sum).append('\n');
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
	
	public static int calc_gcd(int a, int b) {
		if(b == 0)
			return a;
		else {
			return calc_gcd(b, a % b);
		}
	}
	
}
