package dp9;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] d = new long[91][2];
		d[1][1] = 1;
		try {
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 2; i <= N; i++) {
				d[i][0] = d[i - 1][0] + d[i - 1][1];
				d[i][1] = d[i - 1][0];
			}
			
			System.out.println(d[N][0] + d[N][1]);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
