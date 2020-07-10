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
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ArmyBuddies12356 {
	
	private void prepare(int []pointerLeft,int[]pointerRight) {
		for(int i=0;i<pointerLeft.length-1;i++) {
			pointerLeft[i]=i-1;
			pointerRight[i]=i+1;
		}
		pointerRight[pointerRight.length-1]=0;
	}
	int count =1;
	private void solve() throws IOException {
		int s=-1,b=-1;
		while((s=readInteger())!=0 && (b=readInteger())!=0) {
			int[] pointerLeft = new int[s+1];
			int[] pointerRight = new int[s+1];
			prepare(pointerLeft,pointerRight);

			while(b-->0) {
				int l =readInteger();
				int r=readInteger();
				int sL = pointerLeft[l];
				int sR = pointerRight[r];
				
				if(sL==0)
					wr.print("*");
				else
					wr.print(sL);
				if(sR==0)
					wr.println(" *");
				else
					wr.println(" "+sR);
				pointerLeft[sR] = sL;
				pointerRight[sL] = sR;
			}
			wr.println("-");
		}
	}

	public static void main(String[] args) {
		ArmyBuddies12356 var = new ArmyBuddies12356();
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
