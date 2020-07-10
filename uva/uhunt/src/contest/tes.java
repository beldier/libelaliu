package contest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class tes {
	public static void main(String args[])throws IOException{
		int times =100;
		 Random random = new Random();
		int a = 1;
		
		while(times-->0) {
			System.out.println((a++)+" "+a);
			
		}
		//		PrintWriter wr = new PrintWriter(new File("src/utils/output"));
//		int[][] a = new int[1000][1000];
//		for (int i = 0; i < a.length; i++) {
//			a[i][i]=1;
//		}
//		for (int i = 0; i < a.length; i++) {
//			for (int j = 0; j < a.length; j++) {
//				wr.print(a[i][j]);
//			}
//			wr.println();
//		}
//		wr.close();
	}
}
