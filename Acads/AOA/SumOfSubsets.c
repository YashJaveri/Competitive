#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

int inc[50], w[50], sum;

int promising(int i, int wt, int rem)
{
    return ((wt + rem >= sum && wt + w[i+1] <= sum) || wt==sum);
}

void sumSubset(int i, int wt, int rem)
{
    int j;
    if (promising(i, wt, rem))
    {
        if (wt == sum)
        {
            printf("\n{\t");
            for (j = 0; j <= i; j++)
                if (inc[j])
                    printf("%d\t", w[j]);
            printf("}\n");
        }
        else
        {
            inc[i + 1] = TRUE;
            sumSubset(i + 1, wt + w[i + 1], rem - w[i + 1]);
            inc[i + 1] = FALSE;
            sumSubset(i + 1, wt, rem - w[i + 1]);
        }
    }
}

int main()
{
    int i, j, n, temp, total = 0;
    printf("\nEnter Number of Elements: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        scanf("%d", &w[i]);
        total += w[i];
    }

    printf("\n Input the sum value to create sub set:\n");
    scanf("%d", &sum);
    for (i = 0; i <= n; i++)
    {
        for (j = 0; j < n - 1; j++)
            if (w[j] > w[j + 1])
            {
                temp = w[j];
                w[j] = w[j + 1];
                w[j + 1] = temp;
            }
    }

    if ((total < sum))
        printf("\n Subset construction is not possible");
    else
    {
        for (i = 0; i < n; i++)
            inc[i] = 0;
        printf("\n Possible solution using backtracking is:\n");
        sumSubset(-1, 0, total);
    }

    return 0;
}