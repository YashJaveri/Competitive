#include <stdio.h>
#include <stdlib.h>

int main()
{
    int b[10], p[10], blockArr[10], bno, pno, fragments[10], highest = 0, temp, flags[10], allocation[10], i, j;
    for (i = 0; i < 10; i++)
    {
        flags[i] = 0;
        allocation[i] = -1;
    }
    printf("Enter no. of blocks: ");
    scanf("%d", &bno);
    printf("Enter no. of process: ");
    scanf("%d", &pno);
    printf("Enter blocks: ");
    for (i = 0; i < bno; i++)
        scanf("%d", &b[i]);
    printf("Enter process size: ");
    for (i = 0; i < pno; i++)
        scanf("%d", &p[i]);

    for (i = 0; i < pno; i++)
    {
        for (j = 0; j < bno; j++)
        {
            if (flags[j] != 1)
            {
                printf("b: %d, p: %d", b[j], p[i]);
                temp = b[j] - p[i];
                printf("temp: %d, ", temp);
                if (temp >= 0)
                {
                    if (highest < temp)
                    {
                        allocation[i] = j;
                        highest = temp;
                    }
                }
            }
        }
        fragments[i] = highest;
        flags[allocation[i]] = 1;
        highest = 0;
    }
    printf("\nProcess no.\t\tproc size\t\t\tblock no.\t\tblock size\t\tfragement");
    for (i = 0; i < pno && allocation[i] != -1; i++)
        printf("\n%d\t\t%d\t\t\t%d\t\t%d\t\t%d", i, p[i], allocation[i], b[allocation[i]], fragments[i]);
    printf("\n");
    return 0;
}