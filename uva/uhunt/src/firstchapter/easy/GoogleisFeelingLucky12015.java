package firstchapter.easy;

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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class GoogleisFeelingLucky12015 {
	
	private void solve() throws IOException {
		int t = readInteger();
		for (int i = 1; i <= t; i++) {
			int webs = 10;
			Map<Integer,LinkedList<String>> mapa = new HashMap<Integer, LinkedList<String>>();
			int max = -1;
			while( webs -->0) {
				String url = read();
				int value = readInteger();
				if( value > max  )
					max = value;
				if(mapa.get(value) == null) {
					LinkedList<String> tmp = new LinkedList<String>();
					tmp.add(url);
					mapa.put(value, tmp);
				}
				else
					mapa.get(value).add(url);
			}
			LinkedList<String> res  =mapa.get(max);
			wr.printf("Case #%d:\n",i);
			for(String s:res)
				wr.println(s);
		}
	}

	public static void main(String[] args) {
		GoogleisFeelingLucky12015 var = new GoogleisFeelingLucky12015();
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
