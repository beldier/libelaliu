package firstchapter.palindrome;

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

public class Palindromes401 {
	
	private boolean isPalindrome(String w) {
		for (int i = 0,j=w.length()-1; i <= j; i++,j--) {
			if(w.charAt(i) != w.charAt(j))
				return false;
		}
		return true;		
	}
	private boolean isMirroredPalindrome(String w) {
		for (int i = 0,j=w.length()-1; i <= j; i++,j--) {
			if(map(w.charAt(i)) != w.charAt(j) || w.charAt(i) != map(w.charAt(j)))
				return false;
		}
		return true;		
	}

	private char map(char c) {
		switch (c) {
			case 'A':return 'A';
			case 'E':return '3';
			case 'H':return 'H';
			case 'I':return 'I';
			case 'J':return 'L';
			case 'L':return 'J';
			case 'M':return 'M';
			case 'O':return 'O';
			case 'S':return '2';
			case 'T':return 'T';
			case 'U':return 'U';
			case 'V':return 'V';
			case 'W':return 'W';
			case 'X':return 'X';
			case 'Y':return 'Y';
			case 'Z':return '5';
			case '1':return '1';
			case '2':return 'S';
			case '3':return 'E';
			case '5':return 'Z';
			case '8':return '8';
			default : return '^';
		}
	}
	private String transform(String w) {
		char[] ans=w.toCharArray();
		for (int i = 0; i < ans.length; i++) {
			ans[i]= map(ans[i]);
		}		
		return String.valueOf(ans);
	}
	private void solve() throws IOException {
		boolean line=false;
		while(true) {
			if(line)
				wr.println();
			line=true;
			String word = read();
			String mapped= transform(word);
			boolean palindrome=(isPalindrome(word));
			boolean mirrored = isMirroredPalindrome(word);
			wr.print(word+" -- ");
			if(word.equals(mapped)&&mirrored)
				wr.println("is a mirrored palindrome.");
			else
				if(mirrored)
					wr.println("is a mirrored string.");
				else
					if(palindrome)
						wr.println("is a regular palindrome.");
					else
						wr.println("is not a palindrome.");
		}
	}

	public static void main(String[] args) {
		Palindromes401 var = new Palindromes401();
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
