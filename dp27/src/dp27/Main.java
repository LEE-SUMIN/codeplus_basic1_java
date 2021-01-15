package dp27;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[] d = new int[N + 1];
			
			if(N % 2 != 0) {
				System.out.println(0);
				return;
			}
			else {
				d[2] = 3;
				for(int i = 4; i < N + 1; i += 2) {
					d[i] = d[i - 2] * d[2] + 2;
					if(i > 4) {
						for(int j = 2; j < i - 3; j += 2) {
							d[i] += (2 * d[j]);
						}
					}
				}
			}
			System.out.println(d[N]);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
