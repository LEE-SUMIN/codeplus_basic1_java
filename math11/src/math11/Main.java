package math11;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		try {
			String input = br.readLine();
			int num = 0;
			for(int i = 0; i < input.length(); i++) {
				int k = input.length() - i - 1;
				num += (Math.pow(2, k % 3) * (input.charAt(i) - 48));
				if(k % 3 == 0) {
					sb.append(num);
					num = 0;
				}
			}
			
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
