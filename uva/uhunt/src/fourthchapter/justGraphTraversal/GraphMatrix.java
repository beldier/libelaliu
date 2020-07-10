package fourthchapter.justGraphTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphMatrix {

    private boolean[][] adjMatrix;
    private int amountVertices;
    private boolean[] visited;
    public GraphMatrix(int amountVertices) {
        this.amountVertices = amountVertices;
        adjMatrix = new boolean[amountVertices][amountVertices];
        visited= new boolean[amountVertices];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }
    public boolean isVisited(int n) {
    	return visited[n];
    }
    public void setVisited(int n,boolean value) {
    	visited[n]=value;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }
    public List<Integer> DFS(int ini){
    	List res = new ArrayList<Integer>();
    	res.add(ini);
    	setVisited(ini, true);
    	return DFS(ini, res );
    }
    
    private List<Integer> DFS(int ini,List<Integer> ans){
        for(int i=0; i < this.amountVertices;++i) {
        	if((!visited[i]) && adjMatrix[ini][i]) {
        		setVisited(i, true);
        		ans.add(i);
        		System.out.println(i);
        		DFS(i, ans);
        	}
        }
        return ans;
    }
    public List<Integer> BFS(int ini){
    	List res = new ArrayList<Integer>();
    	return BFS(ini, res );
    }
 
    private List<Integer> BFS(int ini,List<Integer> ans){
        Queue<Integer> q= new LinkedList<Integer>();
        q.offer(ini);
        while(!q.isEmpty()){
            Integer current = q.poll();
            ans.add(current);
            setVisited(current,true);
            for(int i=0;i<amountVertices;i++){
            	if((!visited[i]) && adjMatrix[current][i]) {
                    q.offer(i);
                }
            }
        }
        return ans;
    }    
    public static void main(String args[]) {
        GraphMatrix g = new GraphMatrix(10);

        g.addEdge(0, 1);
        g.addEdge(0, 7);
        g.addEdge(0, 4);
        g.addEdge(0, 8);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(6, 9);

        System.out.println(g.BFS(0).toString());
    }
}