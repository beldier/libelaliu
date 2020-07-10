package fourthchapter.minimumSpanningTree;

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

public class Oreon1208 {
	private List<Node> kruskal(List<Node> nodes,int m) {
		List<Node> ans = new ArrayList<>();
		UnionFind uf = new UnionFind(m);
		for(Node n:nodes) {
			if(!uf.isSameSet(n.x, n.y)) {
				uf.unionSet(n.x, n.y);
				ans.add(n);
			}
		}
		return ans;
	}
	private char getChar(int n) {
		return (char)(n+65);
	}
	
	private void solve() throws IOException {
		int t = readInteger();
		for(int i=1;i<=t;i++) {
			int n= readInteger();
			int nc =n;
			int x = 0;
			List<Node> nodes = new ArrayList<>();
			while(nc-->0) {
				String[] elements= scan.readLine().replaceAll(" ", "").split(",");
				for (int y = x; y < elements.length; y++) {
					long value=Long.parseLong(elements[y]);
					if(value>0)
						nodes.add(new Node(x, y, value));	
				}
				x++;
			}
			Collections.sort(nodes);
			List<Node> ans = kruskal(nodes, n);
			wr.printf("Case %d:\n",i);
			for(Node w:ans) {
				wr.printf("%c-%c %d\n", getChar(w.x),getChar(w.y),w.z);
			}
		}
	}

	public static void main(String[] args) {
		Oreon1208 var = new Oreon1208();
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
		
		public void unionSet(int i, int j) { 
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
	}
	class Node implements Comparable<Node>{
		int x;
		int y;
		long z;
		public Node(int x,int y,long z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
		@Override
		public int compareTo(Node n) {
			return Long.compare(z, n.z);
		}	
	}
}
