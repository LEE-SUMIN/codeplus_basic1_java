package dp21;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[][] d = new int[N + 1][];
			int[][] p = new int[N + 1][];
			
			for(int i = 1; i < N + 1; i++) {
				d[i] = new int[i];
				p[i] = new int[i];
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < i; j++) {
					p[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			d[1][0] = p[1][0];
			
			for(int i = 2; i < N + 1; i++) {
				d[i][0] = d[i - 1][0] + p[i][0];
				for(int j = 1; j < i - 1; j++) {
					d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + p[i][j];
				}
				d[i][i - 1] = d[i - 1][i - 2] + p[i][i - 1];
			}
			int max = 0;
			for(int i = 0; i < N; i++) {
				max = Math.max(max, d[N][i]);
			}
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
