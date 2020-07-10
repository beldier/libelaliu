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

public class BlowingFuses661 {
	
	private void solve() throws IOException {
		int n =-1,m=-1,c=-1;
		int seq = 1;
		while((n=readInteger())!=0&&(m=readInteger())!=0&&(c=readInteger())!=0) {
			int[] fuses=new int[n+1];
			boolean[] turnOn = new boolean[n+1];
			int max = -1;
			int currValue = 0;
			for (int i = 1; i < fuses.length; i++) {
				fuses[i]=readInteger();
			}
			while(m-->0) {
				int order =readInteger();
				if(turnOn[order]) {
					currValue-=fuses[order];
					
				}
				else {
					currValue+=fuses[order];
				}
				if(currValue>max)
					max=currValue;
				turnOn[order]=!turnOn[order];
			}
			wr.println("Sequence "+seq);
			if(max>c)
				wr.println("Fuse was blown.");
			else
				wr.println("Fuse was not blown.\n"
						+ "Maximal power consumption was "+max+" amperes.");
			wr.println();
			seq++;
		}
	}

	public static void main(String[] args) {
		BlowingFuses661 var = new BlowingFuses661();
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
