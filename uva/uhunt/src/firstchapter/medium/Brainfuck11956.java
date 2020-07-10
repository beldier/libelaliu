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

public class Brainfuck11956 {
	
	private void solve() throws IOException {
		int t =readInteger();
		for (int i = 1; i <=t ; i++) {
			int[] tape = new int[100];
			String line= scan.readLine();
			int pointer=0;
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				if(c == '<') {
					pointer--;
					if(pointer==-1)
						pointer=99;
				}
				else {
					if(c == '>') {
						pointer++;
						if(pointer==100)
							pointer=0;
					}
					else {
						if(c == '+') {
							tape[pointer]++;
							if(tape[pointer]==256)
								tape[pointer]=0;
						}
						else {
							if(c=='-') {
								tape[pointer]--;
								if(tape[pointer]==-1)
									tape[pointer]=255;
							}
//							else
//								wr.println(Integer.toHexString(tape[pointer]));
						}
					}
						
				}
			}
			String ans="";
			for (int j = 0; j < tape.length; j++) {
				ans = ans+(String.format("%2s", Integer.toHexString(tape[j]).toUpperCase()).replace(' ', '0')+" ");
			}
			ans=ans.trim();
			wr.printf("Case %d: %s\n", i,ans); 
		}
	}

	public static void main(String[] args) {
		Brainfuck11956 var = new Brainfuck11956();
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
