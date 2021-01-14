package dp19;

import java.io.*;
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
				int num = Integer.parseInt(br.readLine());
				int[][] d = new int[num + 1][3];
				int[][] score = new int[2][num + 1];
				
				for(int i = 0; i < 2; i++) {
					tokenizer = new StringTokenizer(br.readLine());
					for(int j = 1; j < num + 1; j++) {
						score[i][j] = Integer.parseInt(tokenizer.nextToken());
					}
				}
				
				for(int i = 1; i < num + 1; i++) {
					d[i][0] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
					d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + score[0][i];
					d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + score[1][i];
				}
				
				int max = Math.max(d[num][0], d[num][1]);
				max = Math.max(max, d[num][2]);
				
				sb.append(max).append('\n');
				
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
