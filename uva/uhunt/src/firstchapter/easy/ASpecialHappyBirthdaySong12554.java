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
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ASpecialHappyBirthdaySong12554 {
	
	private void solve() throws IOException {
		int n = readInteger();
		String[] people = new String[n];
		String[] song = "Happy birthday to you Happy birthday to you Happy birthday to Rujia Happy birthday to you".split(" ");
		int times = people.length / song.length;
		if(people.length % song.length != 0)
			times+=1;
		
		for (int i = 0; i < n; i++) {
			people[i]=read();
		}
		int words = times * song.length;
		int np=0;
		int ns=0;
		while(words --> 0 ) {
			wr.printf("%s: %s\n", people[np++],song[ns++]);
			if(np==people.length) np = 0;
			if(ns == song.length) ns =0;
		}
	}

	public static void main(String[] args) {
		ASpecialHappyBirthdaySong12554 var = new ASpecialHappyBirthdaySong12554();
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
