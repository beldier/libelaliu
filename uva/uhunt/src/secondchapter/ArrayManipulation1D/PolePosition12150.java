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

public class PolePosition12150 {
	
	private int[] checkForZero(int[]results,int[]effects) {
		int[] original =new int[results.length];
		for(int i=0;i<results.length;i++) {
			if(effects[i]==0)
				original[i]=results[i];
		}
		return original;
	}
	private void solve() throws IOException {
		int n = -1;
		while((n=readInteger()) != 0) {
			int[] results = new int[n];
			int[] effects = new int[n];
			int[] original = new int[n];
			for(int i=0;i<n;i++) {
				results[i] = readInteger();
				effects[i] = readInteger();
			}
			original = checkForZero(results,effects);
			boolean impossible = false;
			for(int i = 0 ; i<results.length && !impossible;i++) {
				int newPosition = i+effects[i];
				if(newPosition>= results.length || newPosition < 0) {
					impossible = true;
				}
				else {
					if(effects[i]!=0) {
						if(effects[i]==0 && original[newPosition] != results[i]) {
							impossible = true;
						}
						else {
							if(original[newPosition] != 0) {
								impossible = true;
							}
							else {
								original[newPosition] = results[i];
							}
						}
					}
				}
			}
			if(impossible) {
				wr.println("-1");
			}
			else {
				boolean space = false;
				for(int i=0;i<original.length;++i) {
					
					if(space)
						wr.print(" ");
					space =true;
					wr.print(original[i]);
				}
				wr.println();
			}
		}
	}

	public static void main(String[] args) {
		PolePosition12150 var = new PolePosition12150();
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
