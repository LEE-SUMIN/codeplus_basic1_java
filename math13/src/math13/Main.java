package math13;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		try {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				sb.append(0);
			}

			while(num != 0) {
				if(num % -2 == 0) {
					sb.insert(0, 0);
					num /= -2;
				}
				else {
					sb.insert(0, 1);
					num = (num - 1) / -2;
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
