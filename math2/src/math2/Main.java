package math2;

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
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			
			sb.append(get_gcd(a, b)).append('\n');
			sb.append(get_lcm(a, b));
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static int get_gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		else {
			return get_gcd(b, a % b);
		}
	}
	
	public static int get_lcm(int a, int b) {
		return a * b / get_gcd(a, b);
	}
	
}
