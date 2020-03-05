import java.io.*;

class HashCode {

    public static void main(String[] args) {
        File file = new File("/Users/yashjaveri/Documents/CE/Java/b_read_on.txt");

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));        
            String st; 
            while ((st = br.readLine()) != null) 
            {

            }       
        } catch (IOException e) {            
            e.printStackTrace();
        }
    }
}