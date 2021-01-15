package dp23;
import java.io.*;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] seq = new int[N];
			int[] len = new int[N];
			
			int max = 1;
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N; i++) {
				len[i] = 1;
				for(int j = 0; j < i; j++) {
					if(seq[j] > seq[i]) {
						len[i] = Math.max(len[i], len[j] + 1);
						if(len[i] > max) {
							max = len[i];
						}
					}
				}
			}
			
			System.out.println(max);	
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
