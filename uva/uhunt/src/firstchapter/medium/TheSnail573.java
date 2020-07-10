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

public class TheSnail573 {
	
	private void solve() throws IOException {
		while(true) {
			double h =readDouble();
			double u =readDouble();
			double d =readDouble();
			double f =readDouble();
			if(h == 0.0)break;
			final double  descend = (u*(f/100.0));
			double curr = 0.0;
			int day = 1;
			while(true) {
				if(u>0.0)
					curr+=u;
				if(curr>h)
					break;
					
				u-=descend;
				curr-=d;
				if(curr<0.0)
					break;
				day++;
			}
			if(curr>=h)
				wr.println("success on day "+day);
			else
				wr.println("failure on day "+day);
			
		}
	}

	public static void main(String[] args) {
		TheSnail573 var = new TheSnail573();
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
