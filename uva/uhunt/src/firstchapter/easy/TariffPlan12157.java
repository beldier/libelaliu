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

public class TariffPlan12157 {
	private int calculateCall(int duration,int time,int ratio) {
		return (((duration/time)+1)*ratio);
	}
	private int calculateCalls(int[]calls,int time,int ratio) {
		int ans =0;
		for (int i = 0; i < calls.length; i++) {
			ans+=calculateCall(calls[i], time, ratio);
		}
		return ans;
	}
	private void solve() throws IOException {
		int t = readInteger();
		for ( int x = 1;x<=t;x++) {
			int n = readInteger();
			int[] calls = new int[n];
			for (int i = 0; i < n; i++) {
				calls[i]=readInteger();
			}
			int mile = calculateCalls(calls, 30, 10);
			int juice = calculateCalls(calls, 60, 15);
			if(mile == juice)
				wr.printf("Case %d: Mile Juice %d\n",x,mile);
			else
				if(mile < juice)
					wr.printf("Case %d: Mile %d\n",x,mile);
				else
					wr.printf("Case %d: Juice %d\n",x,juice);
			
		}
	}

	public static void main(String[] args) {
		TariffPlan12157 var = new TariffPlan12157();
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
			//if(aux == null){
			//	wr.close();
			//	System.exit(0);
			//}

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
