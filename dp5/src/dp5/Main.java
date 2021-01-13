package dp5;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokenizer;
		
		
		try {
			int N = Integer.parseInt(br.readLine());
			tokenizer = new StringTokenizer(br.readLine());
			int[] price = new int[N + 1];
			int[] d = new int[N + 1];
			for(int i = 1; i < N + 1; i++) {
				price[i] = Integer.parseInt(tokenizer.nextToken());
			}
			d[0] = 0;
			d[1] = price[1];
			
			for(int i = 2; i <= N; i++) {
				for(int j = 1; j <= i; j++) {
					if(d[i] < d[i - j] + price[j]) {
						d[i] = d[i - j] + price[j];
					}
				}
			}
			
			bw.append(d[N] + "");
			bw.close();
			br.close();
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
