package firstchapter.easy;

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
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class EventPlaning11559 {
	
	private void solve() throws IOException {
		while(true) {
			int n = readInteger();
			int b = readInteger();
			int h = readInteger();
			int w = readInteger();
			int minimum = Integer.MAX_VALUE;
			while(h-->0) {
				int p = readInteger();
				for(int i=0;i<w;i++) {
					int a= readInteger();
					if(a>=n) {
						if(p*n <= b) {
							if((p*n)<minimum)
								minimum = p*n;
						}
					}
				}
			}
			if(minimum == Integer.MAX_VALUE) {
				wr.println("stay home");
			}
			else {
				wr.println(minimum);
			}
		}
	
	}

	public static void main(String[] args) {
		EventPlaning11559 var = new EventPlaning11559();
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
