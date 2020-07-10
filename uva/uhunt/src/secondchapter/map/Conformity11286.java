package secondchapter.map;

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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Conformity11286 {
	
	private void solve() throws IOException {
		int n = -1;
		while((n=readInteger())!=0) {
			Map<String, Integer> mapa =new HashMap<String, Integer>();
			int min = -1;
			int ans=0;
			while(n-->0) {
				String [] courses = scan.readLine().split(" ");
				Arrays.sort(courses);
				String course =Arrays.toString(courses);
				mapa.putIfAbsent(course, 0); 
				int value =mapa.get(course)+1;
				mapa.put(course,value);
				if(value == min) {
					ans+=value;
				}
					if(value>min) {
						min=value;
						ans=value;
					}
			}
//			wr.println(mapa);
			wr.println(ans);
		}
	}

	public static void main(String[] args) {
		Conformity11286 var = new Conformity11286();
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
