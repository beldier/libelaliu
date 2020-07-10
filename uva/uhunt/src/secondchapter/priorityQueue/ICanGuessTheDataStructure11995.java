package secondchapter.priorityQueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class ICanGuessTheDataStructure11995 {
	
	private void solve() throws IOException {
		Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return  s2 -s1;
            }
        };
		while(true) {
			int n =readInteger();
			PriorityQueue<Integer> prio = new PriorityQueue<Integer>(customComparator);
			Stack<Integer> st = new Stack<Integer>();
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean p = true;
			boolean s = true;
			boolean q = true;
			while(n-->0) {
				int order = readInteger();
				int number = readInteger();
				if(order == 1) {
					prio.add(number);
					st.push(number);
					queue.offer(number);
				}
				else {
					Integer response=-1;
					if(prio.isEmpty())
						p=false;
					else {
						if(p) {
							response=prio.remove();
							if(response!= number)
								p = false;							
						}
					}
					if(st.isEmpty())
						s=false;
					else {
						if(s) {
							response=st.pop();
							if(response!= number)
								s = false;					
						}
					}
					if(queue.isEmpty())
						q=false;
					else {
						if(q) {
							response=queue.poll();
							if(response!= number)
								q = false;
						}
					}
					
				}
			}
			if((s & p & q) || (s & p)|| (s & q) || (p & q)) {
				wr.println("not sure");
			}
			else { 
				if( !p & !s & !q)
					wr.println("impossible");
				else
					if(p)
						wr.println("priority queue");
					else 
						if(q)
							wr.println("queue");
						else
							wr.println("stack");
			}
		}
	}

	public static void main(String[] args) {
		ICanGuessTheDataStructure11995 var = new ICanGuessTheDataStructure11995();
		var.run();
	}

	private BufferedReader scan;
	private StringTokenizer tokenizer;
	private PrintWriter wr;

	public int readInteger() throws IOException {
		return Integer.parseInt(read());
	}

	public long readLong() throws IOException {
		return Long.parseLong(read());
	}

	public double readDouble() throws IOException {
		return Double.parseDouble(read());
	}

	public String read() throws IOException {
		String res = "";
		if (tokenizer.hasMoreTokens()) {
			res = tokenizer.nextToken();
		} else {
			String aux = scan.readLine();
			if(aux == null){
				wr.close();
				System.exit(0);
			}

			tokenizer = new StringTokenizer(aux, " ");
			res = tokenizer.nextToken();
		}
		return res;
	}

	public void run() {
		try {
			scan = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/utils/input")));
			tokenizer = new StringTokenizer("", "");
			//wr = new PrintWriter(new File("src/utils/output"));
			wr = new PrintWriter(System.out);

			solve();

			scan.close();
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
			wr.close();
			System.exit(0);
		}
	}
}
