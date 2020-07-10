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

public class NoProblem11608 {
	
	private int [] fillMonths(String line) {
		String[] nums=line.split(" ");
		int ans[]=new int[12];
		for (int i = 0; i < ans.length; i++) {
			ans[i]=Integer.parseInt(nums[i]);
		}
		return ans;
	}
	private void solve() throws IOException {
		int tests=1;
		int problems = 0;
		while((problems=readInteger())>-1) {
			wr.printf("Case %d:\n",tests++);
			int [] months = fillMonths(scan.readLine());
			for (int i = 0; i < months.length; i++) {
				int curr = readInteger();
				if(curr > problems) {
					wr.println("No problem. :(");
					
				}
				else {
					wr.println("No problem! :D");
					problems-=curr;
				}
				problems+=months[i];
			}
		}
	}

	public static void main(String[] args) {
		NoProblem11608 var = new NoProblem11608();
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
