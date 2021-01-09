package deque1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokenizer;
		
		int N;
		try {
			Deque deque = new Deque();
			N = Integer.parseInt(br.readLine());
			while(N --> 0) {
				String inst = br.readLine();
				tokenizer = new StringTokenizer(inst);
				switch(tokenizer.nextToken()) {
				case("push_back"):
					int item = Integer.parseInt(tokenizer.nextToken());
					deque.push_back(item);
					break;
				case("push_front"):
					int item1 = Integer.parseInt(tokenizer.nextToken());
					deque.push_front(item1);
					break;
				case("pop_back"):
					sb.append(deque.pop_back()).append("\n");
					break;
				case("pop_front"):
					sb.append(deque.pop_front()).append("\n");
					break;
				case("front"):
					sb.append(deque.front()).append("\n");
					break;
				case("back"):
					sb.append(deque.back()).append("\n");
					break;
				case("size"):
					sb.append(deque.size()).append("\n");
					break;
				case("empty"):
					sb.append(deque.empty()).append("\n");
					break;
				}
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

class Deque {
	private ArrayList<Integer> deque = new ArrayList<>();
	int size = 0;
	
	Deque(){}
	
	public void push_front(int item) {
		deque.add(0, item);
		size++;
	}
	
	public void push_back(int item) {
		size++;
		deque.add(item);
	}
	
	public int pop_front() {
		if(this.empty() == 1)
			return -1;
		size--;
		return deque.remove(0);
	}
	
	public int pop_back() {
		if(this.empty() == 1)
			return -1;
		size--;
		return deque.remove(size);
	}
	
	public int size() {
		return size;
	}
	
	public int front() {
		if(this.empty() == 1)
			return -1;
		return deque.get(0);
	}
	
	public int back() {
		if(this.empty() == 1)
			return -1;
		return deque.get(size - 1);
	}
	
	public int empty() {
		if(size == 0)
			return 1;
		else
			return 0;
	}
}
