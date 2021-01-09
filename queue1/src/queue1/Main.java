package queue1;

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
		
		try {
			int N = Integer.parseInt(br.readLine());
			Queue queue = new Queue();
			while(N --> 0) {
				tokenizer = new StringTokenizer(br.readLine());
				String inst = tokenizer.nextToken();
				switch(inst) {
				case("push"):
					int item = Integer.parseInt(tokenizer.nextToken());
					queue.push(item);
					break;
				case("pop"):
					int value = queue.pop();
					sb.append(value).append('\n');
					break;
				case("front"):
					int front = queue.front();
					sb.append(front).append('\n');
					break;
				case("back"):
					int back = queue.back();
					sb.append(back).append('\n');
					break;
				case("size"):
					int size = queue.size();
					sb.append(size).append('\n');
					break;
				case("empty"):
					sb.append(queue.empty()).append('\n');
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

class Queue{
	private ArrayList<Integer> queue = new ArrayList<>();
	int begin = 0;
	int end = 0;
	int size = 0;
	
	public Queue() {	}
	
	public void push(int item) {
		queue.add(item);
		end++;
		size++;
	}
	
	public int pop() {
		if(this.empty() == 1)
			return -1;
		begin++;
		size--;
		return queue.get(begin - 1);
	}
	
	public int size() {
		return size;
	}
	
	public int front() {
		if(this.empty() == 1)
			return -1;
		return queue.get(begin);
	}
	
	public int back() {
		if(this.empty() == 1)
			return -1;
		return queue.get(end - 1);
	}
	
	public int empty() {
		if(begin == end)
			return 1;
		else
			return 0;
	}
}