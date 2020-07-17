// C Program for Floyd Warshall Algorithm
#include <stdio.h>

int V;

#define INF 99999

void printSolution(int dist[15][15])
{
    printf("The following matrix shows the shortest distances"
           " between every pair of vertices \n");
    for (int i = 1; i <= V; i++)
    {
        for (int j = 1; j <= V; j++)
        {
            if (dist[i][j] == INF)
                printf("%7s", "INF");
            else
                printf("%7d", dist[i][j]);
        }
        printf("\n");
    }
}

void floydWarshall(int graph[15][15])
{
    int dist[15][15], i, j, k;

    for (i = 1; i <= V; i++)
        for (j = 1; j <= V; j++)
            dist[i][j] = graph[i][j];

    for (k = 1; k <= V; k++)
    {
        for (i = 1; i <= V; i++)
        {
           
            for (j = 1; j <= V; j++)
            {
                // If vertex k is on the shortest path from
                // i to j, then update the value of dist[i][j]
                if (dist[i][k] + dist[k][j] < dist[i][j])
                    dist[i][j] = dist[i][k] + dist[k][j];
            }
        }
    }

    // Print the shortest distance matrix
    printSolution(dist);
}

int main()
{
    int i, j, graph[15][15];
    printf("Enter the no. of vertices: ");
    scanf("%d", &V);
    printf("Enter the cost:\n");
    for (i = 1; i <= V; i++)
    {
        for (j = 1; j <= V; j++)
            scanf("%d", &graph[i][j]);
    }

    floydWarshall(graph);
    return 0;
}
