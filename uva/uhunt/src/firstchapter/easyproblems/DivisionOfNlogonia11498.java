package firstchapter.easyproblems;

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

public class DivisionOfNlogonia11498 {
	
	private void solve() throws IOException {
		int num = -1;
		while((num = readInteger()) != 0) {
			int x0 = readInteger();
			int y0 = readInteger();
			while(num -- > 0) {
				int x = readInteger();
				int y = readInteger();
				if( x == x0 || y == y0)
					wr.println("divisa");
				else
					if(y > y0) {
						if( x > x0)
							wr.println("NE");
						else
							wr.println("NO");
					}
					else {
						if( x > x0)
							wr.println("SE");
						else
							wr.println("SO");					
					}
			}
		}
	}

	public static void main(String[] args) {
		DivisionOfNlogonia11498 var = new DivisionOfNlogonia11498();
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
