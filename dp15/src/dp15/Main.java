package dp15;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		try {
			int N = Integer.parseInt(br.readLine());
			long[] d = new long[1000001];
			d[0] = 1;
			d[1] = 1;
			d[2] = 2;
			
			for(int i = 3; i < 1000001; i++) {
				d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % 1000000009;
			}
			
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(br.readLine());
				sb.append(d[num]).append('\n');
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
