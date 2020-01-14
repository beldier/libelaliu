package firstchapter.easyproblems;


	import java.util.Scanner;
	public class s
	{
	    public static void main(String[] args)
	    {
	        Scanner scan = new Scanner(System.in);
	        int t = scan.nextInt();
	        s cost = new s();
	        for(int i=0;i<t;i++){
	            int a = scan.nextInt();
	            int b = scan.nextInt();
	            int c = scan.nextInt();

	            int res = cost.numeroMedio(a,b,c);
	        
	            System.out.println("Case "+(i+1)+": "+res);
	        }
	    }

	    public int numeroMedio(int a,int b,int c){
	        int numero = 0;
	        if( a > b && a > c ){
	            if(b > c)
	                numero = b;
	            else 
	                numero = c;
	        }
	        if(b > a && b > c){ 
	            if(a > c){
	                numero = a; 
	            }else{
	                numero = c;
	            }
	        }
	        if(c > a && c > b){
	            if(a > b){
	                numero = a;
	            }else{
	                numero = b;
	            }
	        }
	        return numero;
	    }
	}