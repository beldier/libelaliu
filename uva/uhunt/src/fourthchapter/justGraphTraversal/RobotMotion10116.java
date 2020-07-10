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

public class RobotMotion10116 {
	
	private void solve() throws IOException {
		int rows=-1;
		int columns=-1;
		int start=-1;
		while((rows=readInteger())!=0 && (columns=readInteger())!=0 && (start=readInteger())!=0) {
			char[][] maze=new char[rows][columns];
			int[][] memory=new int[rows][columns];
			for(int i=0;i<maze.length;i++) 
				maze[i]=read().toCharArray();
			int r = 0;
			int c = start-1;
			int steps = 1 ;
			memory[r][c]=1;
			boolean exit=false;
			int loop = 0;
			while(!exit) {
				switch (maze[r][c]) {
					case 'N':r--;break;
					case 'W':c--;break;
					case 'S':r++;break;
					case 'E':c++;break;
				}
				if(r<0 || r >=rows || c<0 || c>=columns) {			
					exit = true;
				}
				else {
					if(memory[r][c]>0) {
						loop = steps - memory[r][c]+1;
						steps=memory[r][c];
						exit = true;
						if(steps==1)
							steps=0;
						else
							steps--;
					
					}
					else {
//						wr.println(r+" "+c);
						steps++;
						memory[r][c]=steps;
					}
				}
			}
			if(loop>0)
				wr.printf("%d step(s) before a loop of %d step(s)\n", steps,loop);
			else
				wr.println(steps+" step(s) to exit");
			
		}
	}

	public static void main(String[] args) {
		RobotMotion10116 var = new RobotMotion10116();
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
