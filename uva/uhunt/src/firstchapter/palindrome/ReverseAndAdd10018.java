package firstchapter.palindrome;

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

public class ReverseAndAdd10018 {
	
	public boolean isPalindrome(String n) {
		for (int i = 0; i < n.length()/2; i++) {
			if(n.charAt(i) != n.charAt(n.length()-1-i))
				return false;
		}
		return true;
	}
	private void solve() throws IOException {
		int t =readInteger();
		while(t-->0) {
			long n = readLong();
			long r= Long.parseLong(new StringBuilder(n+"").reverse().toString());
			int times =1;
			while(!isPalindrome((n+r)+"")) {
				n=n+r;
				r=Long.parseLong(new StringBuilder(n+"").reverse().toString());
				times++;
			}
			wr.println(times+" "+(n+r));
		}
	}

	public static void main(String[] args) {
		ReverseAndAdd10018 var = new ReverseAndAdd10018();
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
