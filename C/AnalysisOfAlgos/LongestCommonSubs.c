#include <stdio.h>
#include <string.h>

char C[20], D[20], A[20], B[20];
;
int M[20][20], i, j, k, m, n, a1, a2;

int MAX(int a1, int a2)
{
    if (a1 >= a2)
        return a1;
    return a1;
}

void LCS()
{
    int i, j;

    for (i = 1; i <= m; i++)
    {
        for (j = 1; j <= n; j++)
        {
            if (C[i] == D[j])
            {
                //printf("%d", M[i][j]);
                M[i][j] = M[i - 1][j - 1] + 1;
            }
            else
            {
                a1 = M[i - 1][j];
                a2 = M[i][j - 1];
                M[i][j] = MAX(a1, a2);
            }
        }
    }
}

int main()
{

    scanf("%s", A);
    scanf("%s", B);

    m = strlen(A);
    n = strlen(B);

    for (i = 0, j = 1; A[i] != '\0'; i++)
        C[j++] = A[i];
    C[j] = '\0';

    for (i = 0, j = 1; B[i] != '\0'; i++)
        D[j++] = B[i];
    D[j] = '\0';

    for (i = 0; i < m; i++)
    {
        for (j = 0; j < n; j++)
            if (i == 0 || j == 0)
                M[i][j] = 0;
    }
    LCS();
    printf("%d", M[m][n]);
    return 0;
}