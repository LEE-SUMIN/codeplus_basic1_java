package dp14;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		try {
			tokenizer = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());
			int K = Integer.parseInt(tokenizer.nextToken());
			
			long[][] d = new long[K + 1][N + 1];
			for(int i = 1; i < N + 1; i++) {
				d[1][i] = 1;
			}
			for(int j = 1; j < K + 1; j++) {
				d[j][0] = 1;
			}
			
			for(int i = 1; i < K + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					for(int k = 0; k <= j; k++) {
						d[i][j] += d[i - 1][j - k];
						d[i][j] %= 1000000000L;
					}
				}
			}
			
			System.out.println(d[K][N]);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
