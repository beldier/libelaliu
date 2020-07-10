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
import java.util.Queue;
import java.util.StringTokenizer;

public class DarkRoads11631 {

	private int kruskal(List<Node> nodes,int m) {
		int ans =0;
		UnionFind uf = new UnionFind(m);
		for(Node n:nodes) {
			if(!uf.isSameSet(n.x, n.y)) {
				uf.unionSet(n.x, n.y);
				ans+=n.z;
			}
		}
		return ans;
	}
	private void solve() throws IOException {
		int m=-1,n=1;
		while((m=readInteger())!=0 && (n=readInteger())!=0) {
			List<Node> nodes = new ArrayList<>();
			long totalAmount = 0;
			long ans=0;
			while(n-->0) {
				int x = readInteger();
				int y = readInteger();
				int z = readInteger();
				nodes.add(new Node(x, y, z));
				totalAmount+=z;				
			}
			Collections.sort(nodes);
			
			wr.println(totalAmount-kruskal(nodes,m));
		}
	}

	public static void main(String[] args) {
		DarkRoads11631 var = new DarkRoads11631();
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
		int z;
		public Node(int x,int y,int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
		@Override
		public int compareTo(Node n) {
			return Integer.compare(z, n.z);
		}	
	}
}
