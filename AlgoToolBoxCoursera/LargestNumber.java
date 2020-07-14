import java.util.*;


public class LargestNumber {
    
    private static char getOp(String a, int index){
        return a.charAt((2*index)-1);
    }

    private static long eval(long t1, char op, long t2){        
        switch(op){
            case '-':
                return t1-t2;                
            case '+':
                return t1+t2;                
            case '*':
                return t1*t2;
            default:
                System.out.print("Failed input!");
                return 0;          
        }
    }

    private static String largestNumber(String a) {
        if(a.length()==3){
            long t1 = Character.getNumericValue(a.charAt(0)), t2 = Character.getNumericValue(a.charAt(2));
            return Long.toString(eval(t1, a.charAt(1), t2));
        }

        long[] numbers = new long[(a.length()+1)/2];
        long[][] Max = new long[(a.length()+1)/2][(a.length()+1)/2], Min = new long[(a.length()+1)/2][(a.length()+1)/2];

        for(int i=0; i<a.length(); i+=2)
            numbers[i/2] = Character.getNumericValue(a.charAt(i));

        for(int i=0; i<(a.length()+1)/2; i++){
            for(int diagRow=0; diagRow<(a.length()+1)/2; diagRow++){
                int diagCol = diagRow+i;

                if(diagCol>=((a.length()+1)/2)) break;
                if(diagCol==diagRow){
                    Max[diagRow][diagCol] = numbers[diagCol];
                    Min[diagRow][diagCol] = numbers[diagCol];
                    continue;
                }
                else{
                    int temp = diagCol;
                    int k=0;
                    long finalMax=Integer.MIN_VALUE, finalMin=Integer.MAX_VALUE;
                    while(diagRow<=temp-k-1){
                        long max1 = Max[diagRow][temp-k-1], max2 = Max[temp-k][diagCol];
                        long min1 = Min[diagRow][temp-k-1], min2 = Min[temp-k][diagCol];
                        long maxHere, minHere;

                        char op = getOp(a, temp-k);
                        if(op=='-')
                        {
                            maxHere = eval(max1, op, min2);
                            minHere = eval(min1, op, max2);
                        }
                        else
                        {
                            maxHere = eval(max1, op, max2);
                            minHere = eval(min1, op, min2);
                        }

                        if(maxHere>finalMax)
                            finalMax = maxHere;
                        if(minHere<finalMin)
                            finalMin=minHere;
                        k++;
                    }
                    Max[diagRow][diagCol] = finalMax;
                    Min[diagRow][diagCol] = finalMin;
                }        
            }
        }
        //System.out.println("Max: "+Arrays.deepToString(Max));
        //System.out.println("Min: "+Arrays.deepToString(Min));
        return Long.toString(Max[0][((a.length()+1)/2)-1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        System.out.println(largestNumber(inp));
        scanner.close();
    }
}

