package dp24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[] seq;
	static int[] incr;
	static int[] decr;
	static int N;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			seq = new int[N];
			incr = new int[N];
			decr = new int[N];
			int max = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}
			increasing();
			reverse_seq();
			decreasing();
			
			for(int i = 0; i < N; i++) {
				max = Math.max(max, incr[i] + decr[N - i - 1] - 1);
			}
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void increasing() {
		for(int i = 0; i < N; i++) {
			incr[i] = 1;
			for(int j = 0; j < i; j++) {
				if(seq[j] < seq[i]) {
					incr[i] = Math.max(incr[i], incr[j] + 1);
				}
			}
		}
	}
	
	public static void decreasing() {
		for(int i = 0; i < N; i++) {
			decr[i] = 1;
			for(int j = 0; j < i; j++) {
				if(seq[j] < seq[i]) {
					decr[i] = Math.max(decr[i], decr[j] + 1);
				}
			}
		}
	}
	
	public static void reverse_seq() {
		for(int i = 0; i < N / 2; i++) {
			int temp = seq[i];
			seq[i] = seq[N - i - 1];
			seq[N - i - 1] = temp;
		}
	}
}