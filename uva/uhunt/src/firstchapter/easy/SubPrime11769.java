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

public class SubPrime11769 {
	
	private void solve() throws IOException {
		int b,n;
		while((b=readInteger())!=0 && (n=readInteger())!=0) {
			int[] banks= new int[b+1];
			for (int i = 1; i < banks.length; i++) {
				banks[i]=readInteger();
			}
			while(n-- > 0) {
				int debtor=readInteger();
				int creditor=readInteger();
				int value=readInteger();
				banks[debtor]-=value;
				banks[creditor]+=value;
			}
			boolean flag=true;
			for (int i = 1; i < banks.length; i++) {
				if(banks[i]<0) {
					flag=false;
					break;
				}
			}
			if(flag)
				wr.println("S");
			else
				wr.println("N");
		}
	}

	public static void main(String[] args) {
		SubPrime11769 var = new SubPrime11769();
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
