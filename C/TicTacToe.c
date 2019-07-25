#include<stdio.h>

static char gridMatrix[3][3];
static int x,y;
static int checkWinner;

void empty(){
for(int i=0;i<3;i++){
 for(int j=0;j<3;j++)
 gridMatrix[i][j] = '-';
 }
}

void getInputX()
{
 printf("Player X, your turn(Enter co-ordinates in the form of i,j(eg:(1,1),(1,2), ...etc)):\n");
 scanf("%d%d",&x,&y);
}

void getInputO()
{
printf("Player O, your turn(Enter co-ordinates in the form of i,j(eg:(1,1),(1,2), ...etc)):\n");
scanf("%d%d",&x,&y);
}

int CheckWinner()
{
  //For Cross:
  if ((gridMatrix[0][0]==gridMatrix[1][1] && gridMatrix[1][1]==gridMatrix[2][2])||(gridMatrix[0][2]==gridMatrix[1][1] && gridMatrix[1][1]==gridMatrix[2][0])) {
    if (gridMatrix[1][1]=='X') {
      printf("Player X wins.\n");
      return 0; //Found the Winner.
    }
    else if (gridMatrix[1][1]=='O'){
      printf("Player O wins.\n");
      return 0; //Found the Winner.
    }
  }
  else
  {
  //For rows:
    for (int i = 0; i < 3; i++) {
        if (gridMatrix[i][0]==gridMatrix[i][1] && gridMatrix[i][1]==gridMatrix[i][2] && gridMatrix[i][0]!='-') {
          if (gridMatrix[i][0]=='X') {
            printf("Player X wins\n");
            break;
            return 0; //Found the Winner.
          }
          else if (gridMatrix[i][0]=='O'){
            printf("Player O wins.\n");
            break;
            return 0; //Found the Winner.
          }
        }
        else{
          continue;
        }
    }
    //For columns:
    for (int i = 0; i < 3; i++) {
        if (gridMatrix[0][i]==gridMatrix[1][i] && gridMatrix[1][i]==gridMatrix[2][i] && gridMatrix[0][i]!='-') {
          if (gridMatrix[0][i]=='X') {
            printf("Player X wins\n");
            break;
            return 0; //Found the Winner.
          }
          else if (gridMatrix[0][i]=='O'){
            printf("Player O wins.\n");
            break;
            return 0;
          }//Found the Winner.
        }
        else{
          continue;
        }
    }
  }
  return 1;
}

void display()
{
  system("cls");
  printf("\n");
 for(int i=0;i< 3;i++){
  for(int j=0;j<3;j++) {
  printf("%c ",gridMatrix[i][j]);
  }
  printf("\n\n");
  }
}

void main()
{
empty();
system("cls");
display();

int switcher = 0;

  for(int i = 0;i<9;i++)
  {
    if(switcher==0)
    {
      getInputX();
      gridMatrix[x-1][y-1] = 'X';
      display();
      switcher = 1;
      checkWinner=CheckWinner();
    }
    else
    {
        getInputO();
        gridMatrix[x-1][y-1] = 'O';
        display();
        switcher = 0;
        checkWinner=CheckWinner();
    }
    if (checkWinner==0){
      printf("Thanks for playing :)\n");
      break;
    }
  }
  if(checkWinner==1){
    printf("Its a tie!\n");
  }
}
