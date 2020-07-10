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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Newspaper11340 {
	
	private void solve() throws IOException {
		int n = readInteger();
		while(n-->0) {
			int k = readInteger();
			Map<Character,Double> dat = new HashMap<>();
			while(k-->0) {
				dat.put(read().charAt(0), readDouble());
			}
			int lines = readInteger();
			double ans = 0;
			while(lines --> 0 ) {
				String[] l= scan.readLine().split(" ");
				for (int i = 0; i < l.length; i++) {
					String word = l[i];
					for (int j = 0; j < word.length(); j++) {
						if(dat.get(word.charAt(j))!=null)
							ans += dat.get(word.charAt(j));
					}
				}
			}
			wr.printf("%.2f$\n",ans/100.0);
		}
		
		
	}

	public static void main(String[] args) {
		Newspaper11340 var = new Newspaper11340();
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
