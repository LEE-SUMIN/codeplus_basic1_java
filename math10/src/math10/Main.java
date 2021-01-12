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
	
	/*
	 public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		try {
			tokenizer = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());
			int S = Integer.parseInt(tokenizer.nextToken());
			int[] distance = new int[N];
			int min = 0;
			tokenizer = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int d = Math.abs(S - Integer.parseInt(tokenizer.nextToken()));
				if(min == 0 || d < min) {
					min = d;
				}
				distance[i] = d;
			}
			int result = find_gcd(min, distance);
			
			System.out.println(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int find_gcd(int n, int[] distance) {
		for(int divisor = n; divisor > 0; divisor--) {
			if(n % divisor == 0) {
				boolean status = true;
				for(int i = 0; i < distance.length; i++) {
					if(distance[i] % divisor != 0) {
						status = false;
						break;
					}
				}
				if(status) {
					return divisor;
				}
			}
		}
		return -1;
	}
}
	 */
	
}