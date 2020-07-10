package secondchapter.ArrayManipulation2D;

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

public class MirrorMirror466 {
	
	private boolean compareMatrix(char[][]a,char[][]b) {
		return Arrays.deepEquals(a, b);
	}
	private void printMatrix(char[][] m ) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				wr.print(m[i][j]+" ");
			}
			wr.println();
		}
		wr.println();
	}
	private char[][] rotate90(char[][] m){
		char[][]ans=new char[m.length][m.length];
		int ians=0;
		int jans=0;
		for (int j = 0; j < m.length; j++) {
			ians =j;
			jans=0;
			for (int i = m.length-1; i >= 0; i--)
				ans[ians][jans++] = (m[i][j]);
		}
		return ans;
	}
	private char[][] rotate180(char[][] m ){
		char[][]ans=new char[m.length][m.length];
		int ians=0;
		int jans=0;
		for (int i = m.length-1; i >= 0; i--) {
			jans=0;
			for (int j = m.length-1; j >= 0; j--) {
				ans[ians][jans++]= m[i][j];
			}
			ians++;
		}
		return ans;
	}
	private char[][] rotate270(char[][] m ){
		char[][]ans=new char[m.length][m.length];
		int ians=0;
		int jans=0;
		for (int j = m.length-1; j >= 0; j--) {
			jans=0;
			for (int i = 0; i < m.length; i++) {
				ans[ians][jans]=m[i][j];
			}
			ians++;
			
		}
		return ans;
	}
	private char[][] verticalReflection(char[][] m ){
		char[][] ans =new char[m.length][m.length];
		for (int i = 0; i < m.length/2; i++) {
			ans[i]=m[m.length-1-i];
			ans[m.length-1-i] = m[i];
		}
		if(m.length%2!=0) 
			ans[m.length/2]=m[m.length/2];
		return ans;
	}
	private void solve() throws IOException {
		int cont = 1;
		while(true) {
			int n = readInteger();
			char[][] before= new char[n][n];
			char[][] after= new char[n][n];
			for(int i=0;i<n;i++) {
				before[i]=read().toCharArray();
				after[i]=read().toCharArray();
			}
			if(compareMatrix(before, after))
				wr.printf("Pattern %d was preserved.\n",cont);
			else
				if(compareMatrix(after, rotate90(before)))
					wr.printf("Pattern %d was rotated 90 degrees.\n",cont);
				else
					if(compareMatrix(after, rotate90(rotate90(before))))
						wr.printf("Pattern %d was rotated 180 degrees.\n",cont);
					else
						if(compareMatrix(after, rotate90(rotate90(rotate90(before)))))
							wr.printf("Pattern %d was rotated 270 degrees.\n",cont);
						else
							if(compareMatrix(after, verticalReflection(before))) //verticalss
								wr.printf("Pattern %d was reflected vertically.\n",cont);
							else
								if(compareMatrix(after, rotate90(verticalReflection(before))))
									wr.printf("Pattern %d was reflected vertically and rotated 90 degrees.\n",cont);
								else
									if(compareMatrix(after, rotate90(rotate90(verticalReflection(before)))))
										wr.printf("Pattern %d was reflected vertically and rotated 180 degrees.\n",cont);
									else
										if(compareMatrix(after, rotate90(rotate90(rotate90(verticalReflection(before))))))
											wr.printf("Pattern %d was reflected vertically and rotated 270 degrees.\n",cont);
										else//default
											wr.printf("Pattern %d was improperly transformed.\n",cont);
								
			
			
			cont++;
		}
	}

	public static void main(String[] args) {
		MirrorMirror466 var = new MirrorMirror466();
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
