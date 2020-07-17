#include <stdio.h>

int main()
{
    int i, j, k, stages, n, c[15][15], cost[15], d[15], path[15];
    printf("Enter the no. of stages and no of vertices: ");
    scanf("%d%d", &stages, &n);
    printf("Enter the cost: ");
    for (i = 1; i <= n; i++)
    {
        for (j = 1; j <= n; j++)
            scanf("%d", &c[i][j]);
    }
    cost[n] = 0;
    int min;
    for (i = n - 1; i >= 1; i--)
    {
        min = 999;
        for (j = i + 1; j <= n; j++)
        {
            if (c[i][j] != 0 && (c[i][j] + cost[j]) < min)
            {
                min = c[i][j] + cost[j];
                d[i] = j;
            }
        }
        cost[i] = min;
    }
    path[1] = 1;
    path[stages] = n;
    for (i = 2; i <= stages-1; i++)
        path[i] = d[path[i - 1]];

    printf("%d\n", cost[1]);
    for (i = 1; i <= stages; i++)
        printf("%d --> ", path[i]);
    return 0;
}