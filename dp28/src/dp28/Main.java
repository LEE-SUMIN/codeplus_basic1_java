package dp28;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] cost;
	static int[][] d;
	static int[] min = new int[3];
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			cost = new int[N + 1][3];
			d = new int[N + 1][3];
			
			for(int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				cost[i][0] = Integer.parseInt(st.nextToken());
				cost[i][1] = Integer.parseInt(st.nextToken());
				cost[i][2] = Integer.parseInt(st.nextToken());
			}
			
			coloring(0);
			coloring(1);
			coloring(2);
			
			int cost = Math.min(Math.min(min[0], min[1]), min[2]);
			System.out.println(cost);
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void coloring(int first) { //0:R 1:G 2:B
		for(int i = 1; i < N + 1; i++) {
			if(i == 1) {
				d[1][0] = d[1][1] = d[1][2] = 0;
				d[1][first] = cost[1][first];
			}
			else {
				for(int j = 0; j < 3; j++) {
					d[i][j] = compare(d[i - 1][(j + 4) % 3], d[i - 1][(j + 5) % 3]);
					if(d[i][j] != 0) {
						d[i][j] += cost[i][j];
					}
				}
			}
		}
		min[first] = compare(d[N][(first + 4) % 3], d[N][(first + 5) % 3]);
	}
	
	public static int compare(int a, int b) {
		if(a == 0)
			return b;
		if(b == 0)
			return a;
		return a >= b ? b : a;
	}

}
