package firstchapter.medium;

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

public class ZerosAndOnes10324 {
	
	private void solve() throws IOException {
		int caso = 1;
		while(true) {
			String line = read();
			int[] flags= new int[line.length()];
			char past = line.charAt(0);
			int pivot = 0;
			for (int i = 1; i < line.length(); i++) {
				char curr = line.charAt(i);
				if(past != curr) {
					pivot = i;
				}
				past = curr;
				flags[i]=pivot;
			}
			wr.printf("Case %d:\n", caso++);
			int n = readInteger();
			while(n-->0) {
				int a=readInteger();
				int b=readInteger();
				if(flags[a]==flags[b])
					wr.println("Yes");
				else
					wr.println("No");
			}
		}
	}

	public static void main(String[] args) {
		ZerosAndOnes10324 var = new ZerosAndOnes10324();
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
