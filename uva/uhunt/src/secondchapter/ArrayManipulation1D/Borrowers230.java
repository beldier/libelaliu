package secondchapter.ArrayManipulation1D;

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

public class Borrowers230 {
	
	class Book implements Comparable<Book>{
		String title;
		String author;
		
		public Book(String title, String author) {
			super();
			this.title = title;
			this.author = author;
		}
		
		@Override
		public int compareTo(Book b) {
			if(this.author.compareTo(b.author)==0) {
				return this.title.compareTo(b.title);
			}
			return this.author.compareTo(b.author);
		}
		
	}
	private void solve() throws IOException {
		String line = " ";
		
		ArrayList<Book> books =new ArrayList<Book>();
		while(!(line = scan.readLine()).equals("END")) {
			String title = line.substring(0,line.lastIndexOf("\"")+1);
			String author = line.substring(line.indexOf("by")+3);
			books.add(new Book(title, author));
		}
		Collections.sort(books);
		boolean[] borrowed = new boolean[books.size()];
		ArrayList<String> aux = new ArrayList<String>();
		ArrayList<Book> pile=new ArrayList<Book>();
		while(!(line = scan.readLine()).startsWith("END")) {
			if(line.equals("SHELVE")){
				Collections.sort(pile);
				for (int i = 0; i <pile.size(); i++) {
					int pivot= borrow(pile.get(i).title,books);
					int bef = before(borrowed, pivot-1);
					if(bef==-1) {
						wr.println("Put "+pile.get(i).title+" first");
					}
					else {
						wr.println("Put "+pile.get(i).title+" after "+books.get(bef).title);
						
					}
					borrowed[pivot]=false;
					
				}
				aux.clear();
				pile.clear();
				wr.println("END");
			}
			else {
				String temp = line.substring(line.indexOf("\""));
				if(line.startsWith("BORROW")){
					int pivot= borrow(temp,books);
					borrowed[pivot]=true;
				}
				else {
					pile.add(getBook(temp, books));
					
				}
			}
		}
	}
	public Book getBook(String title,ArrayList<Book> books) {
		for(Book b:books)
			if(b.title.equals(title))
				return b;
		return null;
	}
	public int before(boolean[] borrowed,int pivot) {
		int ans = -1;
		for(int i=pivot;i>=0;i--) {
			if(!borrowed[i])
				return i;
		}
		return ans;
	}

	public int borrow(String book,ArrayList<Book> books) {
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).title.equals(book))
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		Borrowers230 var = new Borrowers230();
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
