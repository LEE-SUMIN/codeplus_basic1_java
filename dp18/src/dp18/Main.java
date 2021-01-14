package dp18;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[][] d = new int[N + 1][10];
			int sum = 0;
			
			d[0][0] = 1;
			
			for(int i = 1; i < N + 1; i++) {
				d[i][0] = d[i - 1][0] % 10007;
				for(int j = 1; j < 10; j++) {
					d[i][j] = (d[i][j - 1] + d[i - 1][j]) % 10007;
					if(i == N) {
						sum += d[i][j];
						sum %= 10007;
					}
				}
			}
			
			sum += d[N][0] ;
			sum %= 10007;
					
			System.out.println(sum);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
