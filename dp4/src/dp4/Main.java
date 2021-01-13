package dp4;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		try {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			int[] d = new int[11];
			d[0] = 1;
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			
			while(N --> 0) {
				int num = Integer.parseInt(br.readLine());
				if(num < 4)
					sb.append(d[num]).append('\n');
				else {
					for(int i = 4; i <= num; i++) {
						d[i] = d[i - 1] + d[i - 2] + d[i - 3];
					}
					sb.append(d[num]).append('\n');
				}
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
