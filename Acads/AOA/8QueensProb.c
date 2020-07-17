#include <stdio.h>
#include <stdlib.h>

int Board[9], count;

int PlaceQueen(int row, int column)
{
    int i;
    for (i = 1; i <= row - 1; ++i)
    {
        if (Board[i] == column)
            return 0;
        else if (abs(Board[i] - column) == abs(i - row))
            return 0;
    }
    return 1;
}


void print(int n)
{
    int i, j;
    printf("\nSolution %d:\n\n", ++count);

    for (i = 1; i <= n; ++i)
        printf("\t%d", i);

    for (i = 1; i <= n; ++i)
    {
        printf("\n%d", i);
        for (j = 1; j <= n; ++j) //for nxn Board
        {
            if (Board[i] == j)
                printf("\tQ"); //queen at i,j position
            else
                printf("\t-"); //empty slot
        }
    }
    printf("\n");
}

void queen(int row, int n)
{
    int col;
    for (col = 1; col <= n; col++)
    {
        if (PlaceQueen(row, col))
        {
            Board[row] = col;
            if (row == n)
            {
                print(n);
                return;
            }
            else
            {
                queen(row + 1, n);
            }
        }
    }
}

int main()
{
    int n, i, j;

    printf(" - N Queens Problem Using Backtracking -");
    printf("\n\nEnter number of Queens:");
    scanf("%d", &n);
    queen(1, n);
    return 0;
}