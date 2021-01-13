package dp2;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int N = Integer.parseInt(br.readLine());
			Calculation c = new Calculation();
			bw.append(c.calc(N) + "");
			
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

class Calculation{
	int[] d = new int[1001];
	Calculation(){
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
	}
	
	public int calc(int n) {
		if(d[n] > 0)
			return d[n];
		else {
			d[n] = (calc(n - 1) + calc(n - 2)) % 10007;
		}
		return d[n];
	}
}