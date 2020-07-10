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

public class BurgerTime {
	
	private int getFirstPlaceIndex(String highway) {
		for (int i = 0; i < highway.length(); i++) {
			if(highway.charAt(i)=='R' || highway.charAt(i) =='D')
				return i;
		}
		return -1;
	}
	private void solve() throws IOException {
		int n = -1;
		while((n = readInteger())!=0) {
			String highway = read();
			if(highway.contains("Z"))
				wr.println(0);
			else {
				int start = getFirstPlaceIndex(highway);
				char prev = highway.charAt(start);
				int ans= Integer.MAX_VALUE;
				for(int i=start+1;i<highway.length();i++) {
					char curr = highway.charAt(i);
					if(curr != '.') {
						if(prev != curr) {
							if(i-start < ans)
								ans = i-start;
							
						}
						prev = curr;
						start = i;
					}
				}
				wr.println(ans);
			}
			
				
				
		}
	}

	public static void main(String[] args) {
		BurgerTime var = new BurgerTime();
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
