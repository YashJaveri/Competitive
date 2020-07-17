import java.util.*;
import java.io.*;

class Element{
    int index;
    int value;
    Element(int index, int value){
        this.index = index;
        this.value = value;
    }
}

class SlidingWindowMax {
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

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        PriorityQueue<Element> prQueue = new PriorityQueue<Element>((i1, i2) ->
            {
                if (i1.value < i2.value) 
                    return 1; 
                else if (i1.value > i2.value) 
                    return -1;
                return 0;
            });

        for(int i=0; i<k; i++)
            prQueue.add(new Element(i, nums[i]));        

        int i=0;//being removed
        int j=k;//being added
        ans[i] = prQueue.peek().value;

        while(j<nums.length)
        {
            prQueue.add(new Element(j, nums[j]));
            //System.out.println(prQueue);
            i++; j++;
                        
            while(prQueue.peek().index<i)
                prQueue.poll();
            Element el = prQueue.peek();
            ans[i] = el.value;
        }
        return ans;
    }

    static public void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = sc.nextInt();
        int k= sc.nextInt();
        int[] ans = maxSlidingWindow(nums, k);
        for(int i=0; i<ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}