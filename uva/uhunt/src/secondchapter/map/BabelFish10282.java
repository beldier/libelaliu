package secondchapter.map;

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

public class BabelFish10282 {
	
	private void solve() throws IOException {
		String word ="";
		Map<String,String> dict= new HashMap<String, String>();
		while(true) {
			String line = scan.readLine();
			if(line == null || line.isEmpty())
				break;
			tokenizer =new StringTokenizer(line," ");
			word=tokenizer.nextToken();
			String translation =tokenizer.nextToken();
			dict.put(translation,word);
		}
		
		while(true) {
			word = read();
			String ans = dict.get(word);
			if(ans==null)
				wr.println("eh");
			else
				wr.println(ans);
		}
	}

	public static void main(String[] args) {
		BabelFish10282 var = new BabelFish10282();
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
			if(aux == null){
				wr.close();
				System.exit(0);
			}

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
