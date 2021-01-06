package stack3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int num = Integer.parseInt(br.readLine());
			while(num-- > 0) {
				int count = 0;
				String input = br.readLine();
				for(int i = 0; i < input.length(); i++) {
					if(input.charAt(i) == '(') {
						count++;
					}
					else if(input.charAt(i) == ')') {
						count--;
					}
					if(count < 0) {
						bw.append("NO\n");
						break;
					}
				}
				
				if(count == 0)
					bw.append("YES\n");
				else if(count > 0)
					bw.append("NO\n");
			}
			
			bw.flush();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
