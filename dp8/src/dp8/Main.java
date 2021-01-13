package dp8;

import java.io.*;

public class Main {

	public static void main(String[] args) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int N = Integer.parseInt(br.readLine());
				long[][] d = new long[N + 1][10];
				int result = 0;
				
				for(int i = 1; i <= N; i++) {
					for(int j = 0; j < 10; j++) {
						if(i == 1 && j != 0) {
							d[i][j] = 1;
						}
						else {
							if(j == 0) {
								d[i][j] = d[i - 1][1] % 1000000000L;
							}
							else if(j == 9) {
								d[i][j] = d[i - 1][8] % 1000000000L;
							}
							else {
								d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000L;
							}
						}
					}
				}
				
				for(int i = 0; i < 10; i++) {
					result += d[N][i];
					result %= 1000000000L;
				}
				
				System.out.println(result);
				
				
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
	}

}
