import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int dpMat[][] = new int[s.length()+1][t.length()+1];

    for(int i=0; i<=s.length();i++){
        for(int j=0;j<=t.length();j++){
            if(i==0)
              dpMat[i][j] = j;
            else if(j==0)
              dpMat[i][j] = i;
            else if(s.charAt(i-1) == t.charAt(j-1))
                dpMat[i][j] = dpMat[i-1][j-1];
            else
                dpMat[i][j] = Math.min(dpMat[i-1][j-1], Math.min(dpMat[i-1][j], dpMat[i][j-1])) + 1;
        }
    }
    return dpMat[s.length()][t.length()];    
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
    scan.close();
  }

}
