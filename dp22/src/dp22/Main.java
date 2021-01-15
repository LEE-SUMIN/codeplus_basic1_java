package dp22;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] v = new int[N];
			int[] p = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			v[0] = p[0];
			
			for(int i = 1; i < N; i++) {
				v[i] = p[i];
				for(int j = 0; j < i; j++) {
					if(p[i] > p[j]) {
						v[i] = Math.max(v[i], v[j] + p[i]);
					}
				}
			}
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				max = Math.max(max, v[i]);
			}
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
