package secondchapter.ArrayManipulation1D;

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
import java.util.StringTokenizer;

public class MapMaker394 {
	class ArrayAddress{
		int[] C = new int[11];
		int D;
		int base;
		int[][]bounds =new int[10][2];
		int s;
		public ArrayAddress(int b,int s) throws IOException{
			this.base = b;
			this.s =s;
			task();
		}
		private void task()throws IOException
		{
			this.D = readInteger();
			int d = D;
			int aux=0;
			for (int i = 0; i < D; i++) {
				bounds[i][0] = readInteger();
				bounds[i][1] = readInteger();
			}
			C[d] = s;
			aux+= C[d]* bounds[d-1][0];
			while(--d > 0) {
				C[d] = C[1+d] * (bounds[d][1]-bounds[d][0]+1);
				aux += C[d] * bounds[d-1][0];
			}
			C[d] = base - aux;
		}
	}
	private void solve() throws IOException {
		int n=readInteger(),r = readInteger();
		HashMap<String,ArrayAddress> mapa= new HashMap<String, ArrayAddress>(); 
		while(n-->0) {
			mapa.put(read(), new ArrayAddress(readInteger(), readInteger()));
		}
		
		while(r-->0) {
			String name = read();
			ArrayAddress arrayAddress = mapa.get(name);
			int aux = readInteger();
			int value = aux*arrayAddress.C[1];
			wr.printf("%s[%d",name,aux);
			for (int i = 2; i <= arrayAddress.D; i++) {
				aux = readInteger();
				wr.print(", "+aux);
				value += aux*arrayAddress.C[i];
			}
			wr.printf("] = %d\n",(value+arrayAddress.C[0]));
		}
		
	}

	public static void main(String[] args) {
		MapMaker394 var = new MapMaker394();
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
