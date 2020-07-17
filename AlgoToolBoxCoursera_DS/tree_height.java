import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	class Node{
		int value = 0;
		List<Node> childNodes;
		Node(int value){
			this.value = value;
			childNodes = new ArrayList<>();
		}
		
		@Override
		public String toString() {
			String s = "";
			s += this.value + ": ";
			for(Node n: childNodes)
				s += n.value + ", ";
			return s;
		}		
	}
	public class TreeHeight {
		int n;
		List<Node> nodes = new ArrayList<>();
		int root;

		private void print(Object s){        
			System.out.println(s.toString());
		}

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			int[] parent = new int[n];

			for(int i=0; i<n; i++){
				parent[i] = in.nextInt();
				nodes.add(new Node(i));
			}
			for(int i=0; i<n; i++)
			{
				if(parent[i] == -1)
					root = i;
				else
					nodes.get(parent[i]).childNodes.add(nodes.get(i));				
			}
		}

		int computeHeight() {
			if(nodes.size() == 0)
				return 0;
				
			int height = 0;			
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(nodes.get(root));
			while(true){
				int cnt = queue.size();
				if(cnt==0)
					break;
				height++;
				
				while(cnt>0){
					Node node = queue.peek();
					queue.remove();
					for(Node n:node.childNodes)
						queue.add(n);
					cnt--;
				}				
			}
			return height;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {						
						try {
							new tree_height().run();
						} catch (IOException e) {
						}						
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();		
			tree.read();
			System.out.println(tree.computeHeight());		
	}
}
