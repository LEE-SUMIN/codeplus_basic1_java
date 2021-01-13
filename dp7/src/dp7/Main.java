package dp7;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N;
		long[][] d = new long[100001][4];
		d[1][1] = d[2][2] = d[3][1] = d[3][2] = d[3][3] = 1L;
		
		try {
			N = Integer.parseInt(br.readLine());
			
			while(N --> 0) {
				int num = Integer.parseInt(br.readLine());
				
				for(int i = 4; i <= num; i++) {
					if(d[i][1] > 0)
						continue;
					d[i][1] = (d[i - 1][2] + d[i - 1][3]) % 1000000009L;
					d[i][2] = (d[i - 2][1] + d[i - 2][3]) % 1000000009L;
					d[i][3] = (d[i - 3][1] + d[i - 3][2]) % 1000000009L;
				}
				long sum = d[num][1] + d[num][2] + d[num][3];
				sb.append(sum % 1000000009).append('\n');
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
