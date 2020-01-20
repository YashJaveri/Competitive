import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

 static void buildLowestNumber(int min)  
    { 
        String str = Integer.toString(min);
        for(int i=0; i<str.length(); i++){
            StringBuilder builder = new StringBuilder(str);
            builder.deleteCharAt(i);
            String x = builder.toString();
            int temp = Integer.parseInt(x);
            if(min > temp)
                min = temp;
        }
        System.out.println(min);
    }

    public static void main(String[] args) throws java.lang.Exception {
        String T = "";
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[;\n\r]");
        T = sc.next();
        for (int i = 0; i < Integer.parseInt(T); i++) {
            String inp = sc.next();
            buildLowestNumber(Integer.parseInt(inp));
        }
    }
}