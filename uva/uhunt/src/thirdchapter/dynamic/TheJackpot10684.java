package thirdchapter.dynamic;


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
import java.util.Scanner;
import java.util.StringTokenizer;

public class TheJackpot10684{
	private int longestValue(int[] nums) {
		int[] mem = new int[nums.length];
		int max = 0;
		int sum = 0;
		for (int i = 0; i < mem.length; i++) {
			sum =Math.max(sum+nums[i],nums[i]);
			if(sum > max)
				max = sum;
		}
		return max;
	}
	
	private void solve() throws IOException {
		Scanner sc= new Scanner(System.in);
		int n =-1;
		while((n=sc.nextInt()) != 0) {
			int[] nums =new int[n];
			for (int i = 0; i < nums.length; i++) {
				nums[i]=sc.nextInt();
			}
			int ans=longestValue(nums);
			if(ans<=0) {
				
				wr.println("Losing streak.");
			}
			else {
				wr.println("The maximum winning streak is "+ans+".");
			}
		}
	}

	public static void main(String[] args) {
		TheJackpot10684 var = new TheJackpot10684();
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
			if(aux.isEmpty() || aux==null) {
				aux = scan.readLine();
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
