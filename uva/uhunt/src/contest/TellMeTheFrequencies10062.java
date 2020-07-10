package contest;

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

public class TellMeTheFrequencies10062 {
	class Letter implements Comparable<Letter>{
		int ascii;
		int amount;
		public Letter(int ascii,int amount) {
			this.ascii =ascii;
			this.amount = amount;
		}
		@Override
		public int compareTo(Letter x) {
			if(x.amount == this.amount)
				return Integer.compare(x.ascii	, ascii);
			return Integer.compare(amount, x.amount);
		}
	}
	private void solve() throws IOException {
		boolean flag =false;
		while(true) {
			String line = scan.readLine();
			if(line == null) {
				wr.close();
				
				break;
			}
			if(flag)
				wr.println();
			flag = true;
			int[] values= new int[150];
			ArrayList<Letter> ans = new ArrayList<>();
			for(int i = 0;i < line.length();i++) {
				values[line.codePointAt(i)]++;
			}
			for (int i = 0; i < values.length; i++) {
				if(values[i]>0)
					ans.add(new Letter(i, values[i]));
			}
			Collections.sort(ans);
			for(Letter l:ans)
				wr.println(l.ascii+" "+l.amount);
		}

	}

	public static void main(String[] args) {
		TellMeTheFrequencies10062 var = new TellMeTheFrequencies10062();
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
