package thirdchapter.dynamic;

import java.awt.event.ActionEvent;
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

public class Supersale10130 {
	
	private void knapsack(int x,int[] p,int[] w,int[][]memo) {
		
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j < 31; j++) {
				if(w[i] > j) 
					memo[j][i]=memo[j][i-1];
				else
					memo[j][i]=Integer.max(memo[j][i-1], memo[j-w[i]][i-1] + p[i]);
			}
		}
	}
	private void solve() throws IOException {
		int tests  = readInteger();
		while(tests-->0) {
			int n = readInteger();
			int[] p = new int[1001];
			int[] w = new int[1001];
			int [][]memo = new int[31][1001];
			for (int i = 1; i <= n; i++) {
				p[i]=readInteger();
				w[i]=readInteger();
			}
			knapsack(n,p,w,memo);
			int g=readInteger();
			int sum =0;
			while(g-->0) {
				sum+=(memo[readInteger()][n]);
			}
			wr.println(sum);
		}
	}

	public static void main(String[] args) {
		Supersale10130 var = new Supersale10130();
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
	