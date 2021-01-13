package dp10;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] seq = new int[N + 1];
			int[] d = new int[N + 1];
			d[1] = 1;
			
			tokenizer = new StringTokenizer(br.readLine());
			
			for(int i = 1; i < N + 1; i++) {
				seq[i] = Integer.parseInt(tokenizer.nextToken());
			}
			
			for(int i = 2; i < N + 1; i++) {
				d[i] = 1;
				for(int j = 1; j < i; j++) {
					if(seq[i] > seq[j]) {
						if(d[i] < d[j] + 1) {
							d[i] = d[j] + 1;
						}
					}
				}
			}
			
			int max = 0;
			
			for(int i : d) {
				max = Math.max(max, i);
			}
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
