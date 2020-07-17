import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    private static void print(Object s){        
        System.out.println(s.toString());
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> stack = new Stack<>();        
        for (int position = 0; position < text.length(); position++) {            
            char next = text.charAt(position);
            if (next == '(' || next == '[' || next == '{')
            {
                stack.push(new Bracket(next, position));
            }
            else if (next == ')' || next == ']' || next == '}') {                
                if(next == ')' && !stack.empty() && stack.peek().type == '(')
                    stack.pop();
                else if(next == ']' && !stack.empty() && stack.peek().type == '[')
                    stack.pop();
                else if(next == '}' && !stack.empty() && stack.peek().type == '{')
                    stack.pop();
                else{
                    stack.push(new Bracket(next, position));
                    break;
                }     
            }            
        }
        if(stack.size()==0) print("Success");
        else print(stack.peek().position+1);
    }
}
