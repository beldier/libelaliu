package sixChapter.adHoc;

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
import java.util.Stack;
import java.util.StringTokenizer;

public class Uncompress245 {
	
	private boolean isNumber(String w ) {
		for(char c: w.toCharArray())
			if(!Character.isDigit(c))
				return false;
		return true;
	}
	private void solve() throws IOException {
		String line ="";
		Stack<String> st = new Stack<>();
		while(!(line=scan.readLine()).contentEquals("0")) {
			int x=0;
			boolean start= false;
			ArrayList<String> lista=  new ArrayList<>();
			line+="`";
			for(int i = 0 ; i < line.length();i++) {
				char c = line.charAt(i);
				
				
				if(Character.isLetter(c)|| Character.isDigit(c)) {
					if(!start) {
						start = true;
						x=i;
					}
				}
				else {
					if(start) {
						String w = line.substring(x,i);
						if(isNumber(w)) {
							String temp=st.remove(st.size() - Integer.parseInt(w));
							w = temp;
							wr.print(w);
						}
						
						st.push(w);
//						wr.println(Arrays.toString(st.toArray()));
						lista.add(w);
						start=false;
					}
				}
				if(!Character.isDigit(c) && c !='`')
					wr.print(c);
			}
			wr.println();
		}
	}

	public static void main(String[] args) {
		Uncompress245 var = new Uncompress245();
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
