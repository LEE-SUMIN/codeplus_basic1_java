package dp1;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int N = Integer.parseInt(br.readLine());
			Calculation c = new Calculation();
			int count = c.calc(N);
			
			//bw.append(count + "");
			
			//bw.close();
			//br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class Calculation{
	int[] d = new int[1000001];
	
	Calculation() {}
	
	public int calc(int n) {
		if(d[n] > 0) {
			System.out.println("*");
			return d[n];
		}
		if(n == 1) {
			return 0;
		}
		else {
			d[n] = calc(n - 1) + 1;
			if(n % 2 == 0) {
				int temp = calc(n / 2) + 1;
				if(temp < d[n])
					d[n] = temp;
			}
			if(n % 3 == 0) {
				int temp = calc(n / 3) + 1;
				if(temp < d[n])
					d[n] = temp;
			}
		}
		return d[n];
	}
}