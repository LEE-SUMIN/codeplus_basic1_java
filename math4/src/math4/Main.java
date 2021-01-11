package math4;

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
			int count = 0;
			tokenizer = new StringTokenizer(br.readLine());
			
			while(N --> 0) {
				int num = Integer.parseInt(tokenizer.nextToken());
				if(check_prime(num)) {
					count++;
				}
			}
			
			sb.append(count);
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean check_prime(int num) {
		if(num < 2)
			return false;
		else {
			for(int i = 2; i * i <= num; i++) {
				if(num % i == 0)
					return false;
			}
			return true;
		}
	}
}
