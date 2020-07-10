package secondchapter.Collections;

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

public class AutomateTheGrades11777 {
	
	private char score(int note) {
		if(note>=90) return 'A';
		else if(note >= 80) return 'B';
		else if(note >= 70) return 'C';
		else if(note >= 60) return 'D';
		
		return 'F';

	}
	private void solve() throws IOException {
		int tests =readInteger();
		for (int i = 1; i <= tests; i++) {
			int term1 = readInteger();
			int term2 = readInteger();
			int fin= readInteger();
			int attendance = readInteger();
			int ex1 = readInteger();
			int ex2 = readInteger();
			int ex3 = readInteger();
			int examen = (ex1+ex2+ex3-Math.min(ex1, Math.min(ex2, ex3)))/2;
			int ans = term1 + term2 + fin + attendance +examen;	
			char grade = score(ans);
			wr.println("Case "+i+": "+grade);
		}
	}

	public static void main(String[] args) {
		AutomateTheGrades11777 var = new AutomateTheGrades11777();
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
