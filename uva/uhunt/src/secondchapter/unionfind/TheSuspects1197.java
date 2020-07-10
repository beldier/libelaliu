package secondchapter.unionfind;

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

public class TheSuspects1197 {
	class UnionFind {                                             
		  private ArrayList<Integer> p;
		  private ArrayList<Integer> rank;
		  private ArrayList<Integer> setSize;
		  private int numSets;

		  public UnionFind(int n) {
		    p = new ArrayList<>(n);
		    rank = new ArrayList<>(n);
		    setSize = new ArrayList<>(n);
		    numSets = n;
		    for (int i = 0; i < n; i++) {
		      p.add(i);
		      rank.add(0);
		      setSize.add(1);
		    }
		  }
		  
		  public int findSet(int i) { 
		    if (p.get(i) == i) 
		    	return i;
		    else {
		      int ret = findSet(p.get(i)); 
		      p.set(i, ret);
		      return ret; 
		      } 
		    }

		  public boolean isSameSet(int i, int j) { 
			  return findSet(i) == findSet(j); 
		  }

		  private void unionSet(int i, int j) { 
		    if (!isSameSet(i, j)) {
		    	numSets--; 
			    int x = findSet(i);
			    int y = findSet(j);
			    if (rank.get(x) > rank.get(y)) { 
			    	p.set(y, x); 
			    	setSize.set(x, setSize.get(x) + setSize.get(y)); 
			    }
			else{ 
		    	p.set(x, y); 
		    	setSize.set(y, setSize.get(y) + setSize.get(x));
		    	if (rank.get(x) == rank.get(y)) 
		    		rank.set(y, rank.get(y) + 1); 
		    	} 
		    } 
		  }
		  
		  public int numDisjointSets() {
			  return numSets; 
		  }
		  public int sizeOfSet(int i) { 
			  return setSize.get(findSet(i)); 
		  }
	}
	private void solve() throws IOException {
		int n =-1;
		int m = -1;
		while((n=readInteger())+ (m=readInteger())!=0) {
			UnionFind uf = new UnionFind(n);
			while(m-->0) {
				int k = readInteger();
				while(k-->0) {
					int parentGroup = readInteger();//to keep group flat 
					while(k-->0) {
						int member =readInteger();
						uf.unionSet(parentGroup, member);
					}
				}
			}
			wr.println(uf.sizeOfSet(0));
		}
	}

	public static void main(String[] args) {
		TheSuspects1197 var = new TheSuspects1197();
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
