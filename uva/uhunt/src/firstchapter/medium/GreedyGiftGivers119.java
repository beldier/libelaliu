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

public class GreedyGiftGivers119 {
	
	private int find(String name,String[] people) {
		for (int i = 0; i < people.length; i++) {
			if(people[i].contentEquals(name))
				return i;
		}
		return -1;
	}
	StringBuilder sb = new StringBuilder();
	private void solve() throws IOException {
		while(true) {
			int n =readInteger();
			String[] people = new String[n];
			int[] values = new int[n];
			for (int i = 0; i < values.length; i++) {
				people[i]=read();				
			}
			while(n--> 0) {
				String curr = read();
				int posCurr = find(curr, people);
				int money=readInteger();
				int amount = readInteger();
				values[posCurr]-=(amount==0)?0:(money/amount*amount);
				double part = (amount==0)?0:money/amount;
				while(amount --> 0 ) {
					String name = read();
					posCurr = find(name, people);
					values[posCurr]+=part;
				}
			}
			for (int i = 0; i < values.length; i++) {
				sb.append(people[i]+" "+values[i]+"\n");
			}
			sb.append("\n");
		}

	}

	public static void main(String[] args) {
		GreedyGiftGivers119 var = new GreedyGiftGivers119();
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
				sb.deleteCharAt(sb.length()-1);
				wr.print(sb);
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
