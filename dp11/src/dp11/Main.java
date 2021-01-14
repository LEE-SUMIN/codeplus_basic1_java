package dp11;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokenizer;
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] seq = new int[N + 1]; //����
			int[] d = new int[N + 1]; //d[i] = A[1]~A[i]���� A[i]�� ������ ���� �� ���� �� ����
			int[] v = new int[N + 1]; //d[i] ���̸� ���� �κ� �������� A[i] ���� ����� index ��
			d[1] = 1;
			tokenizer = new StringTokenizer(br.readLine());
			
			for(int i = 1; i < N + 1; i++) {
				seq[i] = Integer.parseInt(tokenizer.nextToken());
			}
			
			//�迭 d ä���
			for(int i = 2; i < N + 1; i++) {
				d[i] = 1;
				for(int j = 1; j < i; j++) {
					if(seq[i] > seq[j]) {
						if(d[i] < d[j] + 1) {
							d[i] = d[j] + 1;
							v[i] = j;
						}
					}
				}
			}
			//�ִ� ���� ã��
			int max = 0;
			int max_index = 0;
			for(int i = 1; i < N + 1; i++) {
				if(max < d[i]) {
					max_index = i;
					max = d[i];
				}
			}
			//������ ���� + ���
			String length = d[max_index] + "\n";
			while(max_index != 0) {
				sb.insert(0, ' ').insert(0, seq[max_index]);
				max_index = v[max_index];
			}
			sb.insert(0,  length);
			
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
