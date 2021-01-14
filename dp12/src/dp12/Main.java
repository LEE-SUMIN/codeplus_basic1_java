package dp12;
import java.io.*;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		try {
			int N = Integer.parseInt(br.readLine());
			tokenizer = new StringTokenizer(br.readLine());
			int[] seq = new int[N + 1];
			long[] d = new long[N + 1];
			for(int i = 1; i < N + 1; i++) {
				seq[i] = Integer.parseInt(tokenizer.nextToken());
			}
			for(int i = 1; i < N + 1; i++) {
				d[i] = seq[i];
				if(d[i] < d[i - 1] + d[i]) {
					d[i] = d[i - 1] + d[i];
				}
			}
			long max = d[1];
			for(int i = 1; i < N + 1; i++) {
				max = Math.max(max, d[i]);
			}
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
