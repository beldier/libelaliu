package contest;

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


public class VidriosRotos {
	
	class UnionFind {                                             
		  private ArrayList<Integer> p;
		  private ArrayList<Integer> rank;
		  private ArrayList<Integer> setSize;
		  private int numSets;
		  private int maxSet;
		  boolean encontradoMinimo;

		  public UnionFind(int n) {
			encontradoMinimo=false;
		    p = new ArrayList<>(n);
		    rank = new ArrayList<>(n);
		    setSize = new ArrayList<>(n);
		    numSets = n;
		    maxSet = 0;
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

		    int temp=sizeOfSet(j);
		    if(temp>maxSet)
		    	this.maxSet=temp;
		  }
		  
		  public int numDisjointSets() {
			  return numSets; 
		  }
		  public int sizeOfSet(int i) { 
			  return setSize.get(findSet(i)); 
		  }
	}
	private void solve() throws IOException {
		while(true) {
			int f=-1,c=-1;
			try {
				f = readInteger();
				c = readInteger();
			}catch(Exception e) {
				wr.close();
				System.exit(0);
			}
			UnionFind uf= new UnionFind(f*c+1);//max amount of friends
			char[][] grafo = new char[f][c];
			int id=1;
			for (int i = 0; i < f; i++) {
				String line =scan.readLine();
				grafo[i]=line.toCharArray();
				for (int j = 0; j < c; j++) {				
					if(line.charAt(j)=='1') {
						uf.encontradoMinimo = true;
						if(j-1>=0)//revisar izquierda
							if(grafo[i][j-1]=='1')
								uf.unionSet(id-1, id);
						if(i-1>=0) {//revisar arriba
							if(j-1>=0)//diagonal izq
								if(grafo[i-1][j-1] == '1')
									uf.unionSet(id-c-1, id);
							if(grafo[i-1][j] == '1')
								uf.unionSet(id-c, id);
							if(j+1<c)
								if(grafo[i-1][j+1] == '1')
									uf.unionSet(id-c+1, id);
						}
					}
					id++;
				}
			}
			int ans = uf.maxSet;
			if(ans==0 && uf.encontradoMinimo)
				ans = 1;
			wr.print(ans);
			int vr=readInteger();
			for(int i=0;i<vr;i++) {
				int x=readInteger();
				int y=readInteger();
				id = (x-1)*c+y;
				marcar(x-1,y-1,id,f,c,grafo,uf,i);
				ans = uf.maxSet;
				if(ans==0 && uf.encontradoMinimo)
					ans = 1;
				wr.print(" "+ans);
			}
			wr.println();	
		}
 	}
	private void marcar(int i,int j,int id,int f,int c,char[][]grafo,UnionFind uf,int vr) {
		uf.encontradoMinimo = true;
			grafo[i][j]='1';
		if(j-1>=0)//revisar izquierda
			if(grafo[i][j-1]=='1') {
				uf.unionSet(id-1, id);
			}
		if(i-1>=0) {//revisar arriba
			if(j-1>=0)//diagonal izq
				if(grafo[i-1][j-1] == '1')
					uf.unionSet(id-c-1, id);
			if(grafo[i-1][j] == '1')
				uf.unionSet(id-c, id);
			if(j+1<c)
				if(grafo[i-1][j+1] == '1')
					uf.unionSet(id-c+1, id);
		}
		if(j+1<c)//revisar derecha
			if(grafo[i][j+1]=='1')
				uf.unionSet(id+1, id);
		if(i+1<f) {
			if(j-1>=0)
				if(grafo[i+1][j-1] == '1')//diagona inf izq
					uf.unionSet(id+c-1, id);
			if(grafo[i+1][j]=='1')
				uf.unionSet(id+c, id);
			if(j+1<c)
				if(grafo[i+1][j+1]=='1')
					uf.unionSet(id+c+1, id);
		}
	}

	public static void main(String[] args) {
		VidriosRotos var = new VidriosRotos();
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
