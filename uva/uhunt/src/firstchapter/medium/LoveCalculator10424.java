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

public class LoveCalculator10424 {
	
	private int getUnit(int num) {
		int ans = 0;
			while(num>0) {
				ans+=num%10;
				num/=10;
			}
		if(ans>9)
			ans=getUnit(ans);
		return ans;
	}
	private int getValue(String w) {
		int ans = 0;
		w=w.toLowerCase();
		for (int i = 0; i < w.length(); i++) {
			char c =w.charAt(i); 
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
				ans+=w.codePointAt(i)-96;
		}
		return ans;
	}
	private void solve() throws IOException {
		while(true) {
			String a = scan.readLine();
			String b = scan.readLine();
			if(a==null)
				break;
			double ans = 0;
			double valueA = (double)getUnit(getValue(a)); 
			double valueB = (double)getUnit(getValue(b)); 
			if(valueA > valueB)
				ans=valueB/valueA;
			else
				ans=valueA/valueB;
			System.out.printf("%.2f %s\n",ans*100.0,"%");
		}
	}

	public static void main(String[] args) {
		LoveCalculator10424 var = new LoveCalculator10424();
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
//			String aux = scan.readLine();
//			if(aux == null){
//				wr.close();
//				System.exit(0);
//			}
//
//			tokenizer = new StringTokenizer(aux, " ");
//			res = tokenizer.nextToken();
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
//			e.printStackTrace();
			wr.close();
			System.exit(0);
		}
	}
}
