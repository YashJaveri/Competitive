import java.io.*;
import java.util.*;

public class MakeACake_CodeUncode_2020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> sort_arr = new ArrayList<>();
        ArrayList<Integer> mem = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Boolean flag = true;
        
        for(int i=0; i<length; i++){
            int x = sc.nextInt(); 
            arr.add(x);
            sort_arr.add(x);   
        }
        
        Collections.sort(sort_arr);
        
        for(int i=0; i<length; i++)
            stack.push(sort_arr.get(i));        
        
        for(int i=0; i<length; i++){
            if(!stack.empty()){
                if(arr.get(i) < stack.peek()){
                    mem.add(arr.get(i));
                    Collections.sort(mem);
                    System.out.println("");
                }
                else{
                    stack.pop();
                    System.out.print(arr.get(i));
                    if(mem.size() != 0 && !stack.empty()){
                        while(mem.size() != 0 && mem.get(mem.size()-1)>=stack.peek()){
                            System.out.print(" " + mem.get(mem.size()-1));
                            mem.remove(mem.size()-1);
                            stack.pop();
                            flag = false;
                        }
                    }
                    if (flag){
                        System.out.println();
                        flag = false;
                    }
                }
            }
        }
    }
}