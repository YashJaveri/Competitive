// A Java program for Prim's Minimum Spanning Tree (MST) algorithm. 
// The program is for adjacency matrix representation of the graph 
  
import java.util.*;
  
class MST {   
    int minKey(int key[], Boolean mstSet[], int V) 
    { 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    void printSum(int key[], int V) 
    { 
        int sum = 0;
        for (int i = 0; i < V; i++) 
            sum += key[i];
        System.out.println(sum);
    } 
    void primMST(int graph[][], int V) 
    { 
        int parent[] = new int[V]; 
  
        int key[] = new int[V]; 
  
        Boolean mstSet[] = new Boolean[V]; 
  
        for (int i = 0; i < V; i++) { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) { 
            int u = minKey(key, mstSet, V); 
  
            mstSet[u] = true; 
  
            for (int v = 0; v < V; v++) 

                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
  
        // print the constructed MST 
        printSum(key, V); 
    } 
  
    public static void main(String[] args) 
    { 
    
        Scanner sc = new Scanner(System.in);
        int T, M, N;

        T = sc.nextInt();

        while(T>0){
            N = sc.nextInt();            
            M = sc.nextInt();
            int a, b;
            int graph[][] = new int[N][N];
            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                    graph[i][j] = 2;

            for(int i=0; i<M; i++){
                a = sc.nextInt();
                b = sc.nextInt();

                graph[a-1][b-1] = 1;
                graph[b-1][a-1] = 1;
            }
    
            MST t = new MST();
            t.primMST(graph, N); 

            T--;
        }
    } 
} 