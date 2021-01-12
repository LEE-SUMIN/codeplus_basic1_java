package math14;

import java.io.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		try {
			int N = Integer.parseInt(br.readLine());
			GoldBach gb = new GoldBach();
			
			while(N --> 0) {
				int num = Integer.parseInt(br.readLine());
				sb.append(gb.find_GoldBach(num)).append("\n");
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

class GoldBach{
	boolean[] check = new boolean [1000000];
	
	GoldBach() {
		check[0] = check[1] = check[2] = true;
		for(int i = 3; i * i < 1000000; i += 2) {
			if(!check[i]) {
				for(int j = i * i; j < 1000000; j += (2 * i)) {
					check[j] = true;
				}
			}
		}
	}
	
	public int find_GoldBach(int n){
		int count = 0;
		for(int i = 3; i <= n / 2; i += 2) {
			if(!check[i]) {
				if(!check[n - i]) {
					count++;
				}
			}
		}
		return count;
	}
}
