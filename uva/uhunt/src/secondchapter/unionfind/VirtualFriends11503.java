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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class VirtualFriends11503 {
	
	class UnionFind {                                             
		  private ArrayList<Integer> p;
		  private ArrayList<Integer> rank;
		  private ArrayList<Integer> setSize;
		  private int numSets;

		  public UnionFind(int N) {
		    p = new ArrayList<>(N);
		    rank = new ArrayList<>(N);
		    setSize = new ArrayList<>(N);
		    numSets = N;
		    for (int i = 0; i < N; i++) {
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
		int t = readInteger();
		while(t-->0) {
			int f = readInteger();
			HashMap<String,Integer> friends = new HashMap<String,Integer>();//for keep record of friend id
			UnionFind uf= new UnionFind(100001);//max amount of friends
			int i = 0;
			while(f-->0) {
				String f1 =read();
				String f2 =read();
				int i1=-1;
				int i2=-1;
				if(!friends.containsKey(f1)) {
					friends.put(f1, i);
					i1=i++;
				}
				else {
					i1=friends.get(f1);
				}
				if(!friends.containsKey(f2)) {
					friends.put(f2, i);
					i2=i++;
				}
				else {
					i2=friends.get(f2);
				}
					
				uf.unionSet(i1, i2);
				wr.println(uf.sizeOfSet(i1));
			}
		}
	}

	public static void main(String[] args) {
		VirtualFriends11503 var = new VirtualFriends11503();
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
