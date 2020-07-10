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

public class RequestForProposal10141 {
	class Proposal implements Comparable<Proposal>{
		String name;
		double price;
		int order;
		double compliance;
		public Proposal(String name, double price, int order,double compliance) {
			this.name = name;
			this.price = price;
			this.order = order;
			this.compliance=compliance;
		}
		@Override
		public int compareTo(Proposal p) {
			if(Double.compare(compliance, p.compliance)!=0)
				return Double.compare(compliance, p.compliance)*-1;// to invert to greatest first
			else
				if(Double.compare(price, p.price)!=0)
					return Double.compare(price, p.price);
			return Integer.compare(order, p.order);
		}
		
	}
	private void solve() throws IOException {
		int r = -1,c=-1;
		int prop=1;
		boolean line = false;
		while((r=readInteger())!=0 && (c=readInteger())!=0) {
			if(line)
				wr.println();
			line=true;
			Proposal[] array = new Proposal[c];
			int i=0;
			double requirements = r;
			while(r-->0)
				scan.readLine();
			while(c-->0) {
				String name = scan.readLine();
				double price =readDouble();
				int metRequirements = readInteger();
				array[i++]=new Proposal(name, price, i,(double)metRequirements/(double)requirements);
				while(metRequirements --> 0)
					scan.readLine();
			}
			Arrays.sort(array);
			wr.println("RFP #"+prop++);
			wr.println(array[0].name);
			
		}
	}

	public static void main(String[] args) {
		RequestForProposal10141 var = new RequestForProposal10141();
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
