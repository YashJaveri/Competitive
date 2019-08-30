import java.util.Scanner;

class BubbleSort{
    static int n;
    static int a[];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array:");
        n = sc.nextInt();
        a = new int[n];
        System.out.println("Enter elemnts to be sorted:");
        for(int i=0;i<n;i++){
            int b = sc.nextInt();
            a[i]=b;
        }
        sort();
        display();
    }

    static void sort(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(a[j+1]<a[j]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

    static void display(){
        for(int i=0;i<n;i++){
            System.out.print(a[i] + " ");
        }
    }
}