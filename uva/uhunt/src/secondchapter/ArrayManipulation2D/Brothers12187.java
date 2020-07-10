package secondchapter.ArrayManipulation2D;

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

public class Brothers12187 {
	
	
	private void printMatrix(int[][] m ) {
		boolean space=false;
		for (int i = 0; i < m.length; i++) {
			space = false;
			for (int j = 0; j < m[0].length; j++) {
				if(space)
					wr.print(" ");
				space=true;
				wr.print(m[i][j]);
			}
			wr.println();
		}
	}
	private boolean canAttack(int i,int j,int x,int y,int[][]board,int amountHeirs) {
		boolean ans =false;
		int currentHeir = board[i][j];
		if((x>=0 && x<board.length) && (y>=0 && y<board[0].length)) {
			int targetHeir=board[x][y];
			if(targetHeir == currentHeir + 1)
				ans = true;
			if(targetHeir == 0 && currentHeir == (amountHeirs -1))
				ans = true;
		}
		return ans;
	}
	private int[][] prepareAux(int [][] aux) {
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[0].length; j++) {
				aux[i][j]=-1;
			}
		}
		return aux;
	}
	private int[][] fillUnattacked(int[][]aux, int board[][])
	{
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[0].length; j++) {
				if(aux[i][j] == -1)
					aux[i][j]=board[i][j];
			}
		}
		return aux;
	}
	private int[][]battle(int[][]board,int amountHeirs){
		int[][] aux = new int[board.length][board[0].length];
		aux = prepareAux(aux);
		int x = -1,y =-1; //target coordinates
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				x = i -1;
				y = j;
				if(canAttack(i, j, i -1 , j, board, amountHeirs)) { //up
					aux[x][y] = board[i][j]; 
				}
				x = i;
				y = j + 1;
				if(canAttack(i, j, i , j + 1, board, amountHeirs)) {//right
					aux[x][y] = board[i][j];
				}
				x = i + 1;
				y = j;
				if(canAttack(i, j, i + 1 , j, board, amountHeirs)) {//down
					aux[x][y] = board[i][j];
				}
				x = i ;
				y = j - 1;
				if(canAttack(i, j, i , j - 1, board, amountHeirs)) {//left
					aux[x][y] = board[i][j];
				}
			}
		}
		aux = fillUnattacked(aux, board);
		return aux;
	}	
	private int[][] fillBoard(int r,int c)throws IOException{
		int [][] ans = new int[r][c];
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < c; j++) {
				ans[i][j]=readInteger();
			}
		}
		return ans;
	}

	private void solve() throws IOException {
		int n=-1,r=-1,c=-1,k=-1;
		while((n=readInteger())!=0 && (r=readInteger())!=0 && (c=readInteger())!=0 && (k=readInteger())!=0) {
			int[][]board = fillBoard(r, c);
			while(k-->0)
				board = battle(board,n);
			printMatrix(board);
		}
	}

	public static void main(String[] args) {
		Brothers12187 var = new Brothers12187();
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
