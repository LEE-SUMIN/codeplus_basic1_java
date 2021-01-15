package dp26;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int[] seq;
	static int[] right;
	static int[] left;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			seq = new int[N];
			right = new int[N];
			left = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}
			
			int max1 = left();
			reverse();
			right();
			int max2 = right[N - 1];
			for(int i = 1; i < N - 1; i++) {
				max2 = Math.max(max2, left[i - 1] + right[N - i - 2]);
			}
			max2 = Math.max(max2, left[N - 1]);
			int max = Math.max(max1, max2);
			
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static int left() {
		int max = seq[0];
		left[0] = seq[0];
		for(int i = 1; i < N; i++) {
			left[i] = Math.max(seq[i], left[i - 1] + seq[i]);
			if(left[i] > max) {
				max = left[i];
			}
		}
		return max;
	}

	public static void right() {
		int max = seq[0];
		right[0] = seq[0];
		for(int i = 1; i < N; i++) {
			right[i] = Math.max(seq[i], right[i - 1] + seq[i]);
		}
	}
	
	public static void reverse() {
		for(int i = 0; i < N / 2; i++) {
			int temp = seq[i];
			seq[i] = seq[N - i - 1];
			seq[N - i - 1] = temp;
		}
	}

}
