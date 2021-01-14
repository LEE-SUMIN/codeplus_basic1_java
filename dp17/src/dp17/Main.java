package dp17;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[][] d = new int[N + 1][3];
			
			d[1][0] = 1;
			d[1][1] = 1;
			d[1][2] = 1;
			
			for(int i = 2; i < N + 1; i++) {
				d[i][1] = (d[i - 1][0] + d[i - 1][2]) % 9901;
				d[i][2] = (d[i - 1][0] + d[i - 1][1]) % 9901;
				d[i][0] = (d[i][2] + d[i - 1][2]) % 9901;
			}
			
			System.out.println((d[N][0] + d[N][1] + d[N][2]) % 9901);
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
