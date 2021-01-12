package math10;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		try {
			tokenizer = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());
			int S = Integer.parseInt(tokenizer.nextToken());
			
			tokenizer = new StringTokenizer(br.readLine());
			int sister1 = Integer.parseInt(tokenizer.nextToken());
			int distance1 = Math.abs(S - sister1);
			int result = distance1;
			N--;
			
			while(N --> 0) {
				int sister2 = Integer.parseInt(tokenizer.nextToken());
				int distance2 = Math.abs(S - sister2);
				result = calc_gcd(result, distance2);
			}
			
			System.out.println(result);
			
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