package thirdchapter.greedy;

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

public class TheGrandDinner10249 {
	class Team implements Comparable<Team>{
		int id;
		int amount;
		int[] positions;
		private int index;
		public Team(int id,int amount) {
			this.id = id;
			this.amount = amount;
			positions = new int[amount];
			index=0;
		}
		@Override
		public int compareTo(Team arg0) {
			return Integer.compare(this.amount, arg0.amount);
		}
		public boolean addTableNumber(int n) {
			if(index<positions.length)
				positions[index++]=n;
			else
				return false;
			return true;
		}
		@Override
		public String toString() {
			Arrays.sort(positions);
			String ans =Arrays.toString(positions);
			return ans.substring(1,ans.length()-1).replaceAll(",", "");
		}
	}
	class Table implements Comparable<Table>{
		int id;
		int amount;
		public Table(int id,int amount) {
			this.id = id;
			this.amount = amount;
		}
		@Override
		public int compareTo(Table arg0) {
			return Integer.compare(this.amount, arg0.amount);
		}
		
	}
	private void solve() throws IOException {
		int m =-1, n =-1;
		while((m=readInteger())!=0 && (n=readInteger())!=0) {
			Team[] teams = new Team[m];
			Table[]tables = new Table[n];
			int total=0;
			for (int i = 0; i < teams.length; i++) {
				int a = readInteger();
				total+=a;
				teams[i]=new Team(i,a);
			}
			for (int i = 0; i < tables.length; i++) {
				tables[i]=new Table(i+1,readInteger());
			}
			Arrays.sort(teams,Collections.reverseOrder());
			Arrays.sort(tables);
			for (int i = 0; i < tables.length; i++) {
				int amount =tables[i].amount;
				int iTeam=0;
				while(amount>0 && iTeam<teams.length) {
					if(!teams[iTeam++].addTableNumber(tables[i].id))
						break;
					total--;
					amount--;
				}
			}
			if(total>0) {
				wr.println("0");
			}
			else {
				wr.println("1");
				for(int i = 0;i<teams.length;i++)
					wr.println(search(i,teams).toString());
				}
		}
	}
	private Team search(int i,Team[] teams) {
		for (int j = 0; j < teams.length; j++) {
			if(teams[j].id == i)
				return teams[j];
		}
		return null;
	}

	public static void main(String[] args) {
		TheGrandDinner10249 var = new TheGrandDinner10249();
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
