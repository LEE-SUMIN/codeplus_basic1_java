package dp20;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] quantity = new int[N + 1];
			int[][] d = new int[N + 1][4];
			
			for(int i = 1; i < N + 1; i++) {
				quantity[i] = Integer.parseInt(br.readLine());
			}
			d[1][0] = quantity[1];
			d[1][1] = 0;
			d[1][2] = quantity[1];
			d[1][3] = 0;
			
			for(int i = 2; i < N + 1; i++) {
				d[i][0] = d[i - 1][2] + quantity[i];
				d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]);
				d[i][2] = Math.max(d[i - 1][1], d[i - 1][3]) + quantity[i];
				d[i][3] = Math.max(d[i - 1][1], d[i - 1][3]);
			}
			
			int max = Math.max(Math.max(Math.max(d[N][0], d[N][1]), d[N][2]), d[N][3]);
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
