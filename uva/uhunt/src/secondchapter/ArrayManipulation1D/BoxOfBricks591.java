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

public class BoxOfBricks591 {
	
	private void solve() throws IOException {
		int n = -1;
		int set = 1;
		while((n=readInteger())!=0) {
			int [] bricks = new int[n];
			int sum = 0;
			for (int i = 0; i < bricks.length; i++) {
				bricks[i]=readInteger();
				sum+=bricks[i];
			}
			int avg= sum/n;
			int ans =0;
			for (int i = 0; i < bricks.length; i++) {
				if(bricks[i]>avg)
					ans+=(bricks[i]-avg);
			}
			wr.println("Set #"+set++);
			wr.printf("The minimum number of moves is %d.\n", ans);
		}
	}

	public static void main(String[] args) {
		BoxOfBricks591 var = new BoxOfBricks591();
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
