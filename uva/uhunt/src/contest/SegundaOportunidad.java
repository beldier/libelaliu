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

public class SegundaOportunidad {
	class Pareja {
		Bateria a;
		Bateria b;
		public Pareja(Bateria a,Bateria b) {
			this.a = a;
			this.b = b;
		}
	}
	class Bateria implements Comparable<Bateria>{
		int id;
		int valor;
		int candidato;
		public Bateria(int id,int valor) {
			this.id = id;
			this.valor = valor;
			this.candidato=-1;
		}
		@Override
		public int compareTo(Bateria b) {
			// TODO Auto-generated method stub
			return Integer.compare(this.valor, b.valor);
		}
	}
	public void buscarCandidato(Bateria actual,int pos,Bateria[] baterias,boolean[]flags,int v) {
		for(int i = baterias.length-1;i>pos ;i--) {
			if(baterias[i].valor+actual.valor>= v) {
				if(flags[i])
					continue;
				actual.candidato = i;
				break;//en caso de multiples respuestas deshabilitar
			}
			else
				break;
		}
	}
	private void solve() throws IOException {
		int tests = readInteger();
		while(tests-->0) {
			int b =readInteger();
			int v =readInteger();
			Bateria[] baterias = new Bateria[b];
			boolean[] flags = new boolean[b];
			for (int i = 0; i < baterias.length; i++) {
				baterias[i]=new Bateria(i,readInteger());
			}
			Arrays.sort(baterias);
			
			
			ArrayList<Pareja> parejas = new ArrayList<>();
			for (int i = 0; i < baterias.length; i++) {
				if(flags[i])
					break;
				Bateria actual = baterias[i];
				buscarCandidato(actual,i,baterias,flags,v);
				if(actual.candidato!=-1) {
//					System.out.println("parejas "+actual.valor+" "+ baterias[actual.candidato].valor);
					flags[i]=true;
					flags[actual.candidato]=true;
					parejas.add(new Pareja(actual,baterias[actual.candidato]));
				}
			}

			wr.print(parejas.size()+":");
			for(Pareja p : parejas) {
				wr.print(" "+(p.a.id+1)+" "+(p.b.id+1));
			}
			wr.println();
			
		}
	}

	public static void main(String[] args) {
		SegundaOportunidad var = new SegundaOportunidad();
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
