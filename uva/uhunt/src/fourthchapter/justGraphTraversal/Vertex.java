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
import java.util.Queue;
import java.util.StringTokenizer;


public class Vertex {
	
	private void createNodes(Graph graph) {
		for(int i=1;i<=graph.getAmount();++i) {
			graph.addNode(new Node(i));
		}
	}
	private int countFalses(boolean[] results) {
		int res=0;
		for(int i=1;i<results.length;++i)
			if(results[i]==false)
				res++;
		return res;
	}
	private void solve() throws IOException {
		int amount = -1;
		while((amount = readInteger())!= 0) {
			Graph graph = new Graph(amount);
			createNodes(graph);
			int id = -1;
			while((id = readInteger())!= 0) {
				int vertex = -1;
				Node current = graph.findNode(id);
				while((vertex = readInteger())!=0) {
					Node adjacentNode = graph.findNode(vertex);
					current.addAdjacentNode(adjacentNode);
				}
			}
			int toInvestigate =readInteger();
			while(toInvestigate-->0) {
				int searchId = readInteger();
				boolean [] results = graph.DFS(graph.findNode(searchId));
				int counter = countFalses(results);
				wr.print(counter);
				for(int i=1;i<results.length;i++) {
					if(!results[i]) {
						wr.print(" "+i);
					}
				}
				graph.resetVisited();
				wr.println();
			}
		}
	}

	public static void main(String[] args) {
		Vertex var = new Vertex();
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
	class Node {
		private int id;
		private List<Node> nodes;
		private boolean visited;
		public Node(int id) {
			this.id = id;
			this.nodes=new ArrayList<>();
			this.visited =false;
		}
		public Node(int id,List<Node> nodes) {
			this.id = id;
			this.nodes = nodes;
			this.visited =false;
		}
		
		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean visited) {
			this.visited=visited;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
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
	}
	class Graph {
		private List<Node> nodes;
		private int amount;
		public Graph(int n ) {
			this.nodes = new ArrayList<>();
			this.amount = n;
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

