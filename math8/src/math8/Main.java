package math8;

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
			tokenizer = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			
			int two = count_k(n, 2) - count_k(m, 2) - count_k(n-m, 2);
			int five = count_k(n, 5) - count_k(m, 5) - count_k(n-m, 5);
			sb.append(Integer.min(two, five));
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	static int count_k(int num, int k) {
		int count = 0;
		long div = k;
		while(div <= num) {
			count += (num / div);
			div *= k;
		}
		return count;
	}
}
