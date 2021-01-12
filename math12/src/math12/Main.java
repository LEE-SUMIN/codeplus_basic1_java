package math12;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String input;
		try {
			input = br.readLine();
			if(input.contentEquals("0")) {
				sb.append("0");
			}
			else {
				for(int i = 0; i < input.length(); i++) {
					sb.append(binToOct(input.charAt(i) - 48));
				}
				
				while(sb.charAt(0) == '0') {
					sb.delete(0, 1);
				}
			}
						
			bw.append(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String binToOct(int n) {
		StringBuilder part = new StringBuilder();
		int k = 4;
		for(int i = 0; i < 3; i++) {
			part.append(n / k);
			n %= k;
			k /= 2;
		}
		
		return part.toString();
	}
}
