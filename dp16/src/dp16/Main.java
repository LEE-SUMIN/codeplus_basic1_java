package dp16;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[][] price = new int[N + 1][3];
			int[][] d = new int[N + 1][3];
			
			for(int i = 1; i < N + 1; i++) {
				tokenizer = new StringTokenizer(br.readLine());
				price[i][0] = Integer.parseInt(tokenizer.nextToken());
				price[i][1] = Integer.parseInt(tokenizer.nextToken());
				price[i][2] = Integer.parseInt(tokenizer.nextToken());
			}
			
			
			for(int i = 1; i < N + 1; i++) {
				d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + price[i][0];
				d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + price[i][1];
				d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + price[i][2];
			}
			
			int result = Math.min(d[N][0], d[N][1]);
			result = Math.min(result, d[N][2]);
			System.out.println(result);
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
