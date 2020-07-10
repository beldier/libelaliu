package secondchapter.ArrayManipulation1D;

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

public class SymmetricMatrix11349 {
	
	private boolean symmetric(long[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[j][i]!=mat[mat.length-1-j][mat.length-1-i] || mat[j][i]<0 )
					return false;
			}
		}
		return true;
	}
	private void solve() throws IOException {
		int n =readInteger();
		for (int i = 1; i <= n; i++) {
			read();read();
			int s =readInteger();
			long[][] mat =new long[s][s];
			for (int j = 0; j < mat.length; j++) {
				for (int j2 = 0; j2 < mat.length; j2++) {
					mat[j][j2] =readLong();
				}
			}
			String ans="Symmetric.";
			if(!symmetric(mat))
				ans="Non-symmetric.";
				
			wr.printf("Test #%d: %s\n", i,ans );
		}
	}

	public static void main(String[] args) {
		SymmetricMatrix11349 var = new SymmetricMatrix11349();
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
