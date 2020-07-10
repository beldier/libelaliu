package secondchapter.map;

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

public class Exhibition11348 {
	
	private void solve() throws IOException {
		int k  = readInteger();
		for(int i = 1 ;i<=k;++i) {
			int n=readInteger();
			ArrayList[] collectors = new ArrayList[n];
			double uniques=0.0;
			int[] ids = new int[10001];
			for (int j = 0; j < collectors.length; j++) {
				ArrayList<Integer> collection =new ArrayList<Integer>(51);
				boolean[] dups = new boolean[10001];
				int amount =readInteger();
				while(amount-->0) {
					int id = readInteger();
					if(!dups[id]) {
						dups[id]=true;
						ids[id]++;
						if(ids[id]==1) {
							uniques++;
						}
						else
							if(ids[id]==2)
								uniques--;
						collection.add(id);
					}
				}
				collectors[j]=(collection);
			}
			wr.printf("Case %d: ",i);
			String ans="";
			double total = 0.0;
			for(ArrayList<Integer> l : collectors) {
				total=0.0;
				for (int j = 0; j < l.size(); j++) {
					if(ids[l.get(j)] == 1)
						total++;
				}
				ans = ans + String.format("%.6f%% ", (100/(uniques/total)));
			}
			wr.println(ans.trim());
		}
	}

	public static void main(String[] args) {
		Exhibition11348 var = new Exhibition11348();
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
