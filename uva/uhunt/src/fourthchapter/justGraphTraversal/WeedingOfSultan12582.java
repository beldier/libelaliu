package fourthchapter.justGraphTraversal;

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


public class WeedingOfSultan12582 {
	
	private Graph task(Graph g,Node currNode,String s,int index) {
		if(index<s.length()) {
			if(currNode.getId() == s.charAt(index)) {
				task(g, currNode.prev, s, index+1);
			}
			else {
				Node n = new Node(s.charAt(index));
				g.addNode(n);
				currNode.addRepeat();
				n.setPrev(currNode);
				currNode.addAdjacentNode(n);
				task(g, n, s, index+1);
			}
		}
		return g;
			
	}
	
	private void solve() throws IOException {
		int tests=readInteger();
		for(int i=1;i<=tests;++i) {
			Graph g = new Graph();
			String trails =read();
			Node ini = new Node(trails.charAt(0),0);
			g.addNode(ini);
			task(g, ini, trails, 1);
			List<Node> ans = g.getNodes();
			Collections.sort(ans);
			wr.println("Case "+i);
			for(Node j:ans) 
				wr.printf("%c = %d\n",j.getId(),j.getRepeat());
			
		}
	}

	public static void main(String[] args) {
		WeedingOfSultan12582 var = new WeedingOfSultan12582();
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
	class Node implements Comparable<Node>{
		private char id;
		private List<Node> nodes;
		private boolean visited;
		private Node prev;
		private int repeats;
		public Node(char id) {
			this.id = id;
			this.nodes=new ArrayList<>();
			this.visited =false;
			this.prev = null;
			this.repeats =1;
		}		
		public Node(char id,int repeat) {
			this.id = id;
			this.nodes=new ArrayList<>();
			this.visited =false;
			this.prev = null;
			this.repeats =repeat;
		}
		public void addRepeat() {
			this.repeats++;
		}
		public int getRepeat() {
			return repeats;
		}
		public Node(char id,List<Node> nodes) {
			this.id = id;
			this.nodes = nodes;
			this.visited =false;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node n) {
			this.prev = n;
		}
		
		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean visited) {
			this.visited=visited;
		}
		public char getId() {
			return id;
		}
		public void setId(char id) {
			this.id = id;
		}
		public List<Node> getNodes() {
			return nodes;
		}
		public void setNodes(List<Node> nodes) {
			this.nodes = nodes;
		}
		public void addAdjacentNode(Node e) {
			nodes.add(e);
		}
		@Override
		public String toString() {
			return id+"";
		}
		@Override
		public int compareTo(Node arg0) {
			
			return Character.compare(this.id, arg0.getId());
		}
	}
	class Graph {
		private List<Node> nodes;
		private int amount;
		public Graph(int n ) {
			this.nodes = new ArrayList<>();
			this.amount = n;
		}
		public List<Node> getNodes()
		{
			return nodes;
		}
		public Graph() {
			this.nodes = new ArrayList<>();
			this.amount = 0;
		}
		public void addNode(Node e) {
			nodes.add(e);
		}
		public int getAmount() {
			return amount;
		}
		public Node findNode(int id) {
			Node ans = null;
			for(Node n:nodes) {
				if(n.getId() == id) {
					ans = n;
					break;
				}
			}
			return ans;
		}
		public void resetVisited() {
			for(Node n:nodes) {
				n.setVisited(false);
			}
		}
		public boolean[] DFS(Node ini) {
			boolean[] res= new boolean[this.amount+1]; 
			return DFS(ini,res);
		}
		private boolean[] DFS(Node ini,boolean[]res){
			for(Node n:ini.getNodes()) {
				if(!res[n.getId()]) {
					res[n.getId()]=true;
					DFS(n,res);
				}
			}
			return res;
		}
	}
}
