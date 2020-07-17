#include <stdio.h>

static int matA[100][100];
static int matB[100][100];
static int rA,cA,rB,cB;

void display() {
  system("cls");
  printf("Matrix A:\n");
  for (int i = 0; i < rA; i++) {
    for (int j = 0; j < cA; j++)
        printf("%d ",matA[i][j]);
    printf("\n\n");
  }
  printf("Matrix B:\n");
  for (int i = 0; i < rB; i++) {
    for (int j = 0; j < cB; j++)
        printf("%d ",matB[i][j]);
    printf("\n\n");
  }
}

//To avoid garbage:
void  emptyIt() {
  for (int i = 0; i < rA; i++) {
    for (int j = 0; j < cA; j++)
        matA[i][j]=0;
  }
  for (int i = 0; i < rB; i++) {
    for (int j = 0; j < cB; j++)
        matB[i][j]=0;
  }
}

void  input1() {
  printf("Enter number of valid rows for matrixA:\n");
  scanf("%d",&rA);
  printf("Enter number of valid columns for matrixA:\n");
  scanf("%d",&cA);
  printf("Enter number of valid rows for matrixB:\n");
  scanf("%d",&rB);
  printf("Enter number of valid columns for matrixB:\n");
  scanf("%d",&cB);
}

void input2() {
int a,b;
system("cls");
display();
  for (int i = 0; i < rA; i++) {
    for (int j = 0; j < cA; j++) {
        printf("Enter row %d and column %d 's elemnt for matrix A:\n",i+1,j+1);
        scanf("%d",&a);
        matA[i][j]=a;
        display();
    }
  }
  for (int i = 0; i < rB; i++) {
    for (int j = 0; j < cB; j++) {
        printf("Enter row %d and column %d's elemnt for matrix B:\n",i+1,j+1);
        scanf("%d",&b);
        matB[i][j]=b;
        display();
    }
  }
}

void MultandDisp()
{
  printf("Product =\n\n");
  int x=0,i,j,k;
  for (i = 0; i < rA; i++) {
    for (j = 0;j < cB;j++) {
      for (k = 0; k < cA; k++) {
          x+=matA[i][k]*matB[k][j];
        }
        printf("%d ",x);
        x=0;
      }
      printf("\n\n");
    }
}

void main() {
  do {
    input1();//Ask for input till its valid.
    emptyIt();
  } while(rA!=cB || cA!=rB);
  input2();
  MultandDisp();
  getch();
}
