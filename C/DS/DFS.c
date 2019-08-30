 #include<stdio.h>

	int stk[10];
	int top;
	int adj[10][10];
	int visited[10];

	void push (int item)
	{
		if (top==9)
			printf("Stack overflow");
		else
			stk[++top]=item;
	}

	int pop()
	{
		if (top==-1)
		{
			printf("Stack underflow");
			return 0;
		}
		else
			return (stk[top--]);
	}

	void DFS (int initial_node,int n)
	{
		int u,i;
		top = -1;
		push(initial_node);
		printf("\nDFS traversal for given graph is : ");
		while(top>=0)
		{
			u=pop();
			if(visited[u]==0)
			{
				printf("\n %d  ", u);
				visited[u]=1;
			}
			for (i=1;i<=n;i++)
			{
					if((adj[u][i]==1) && (visited[i]==0))
					{
						push(u);
						visited[i]=1;
						printf(" %d ", i);
						u = i;
				}
			}
		}
	}

	void createGraph()
	{
		int n,c,i,j,parent,adj_parent,initial_node;
		int  ans=0,ans1=0;

		printf("\nEnter total number elements in a Undirected Graph :");
		scanf("%d", &n);
		for ( i=1;i<=n;i++)
			for( j=1;j<=n;j++)
				adj[i][j]=0;

		for (c=1;c<=n;c++)
			visited[c]=0;
		printf("\nEnter graph structure for DFS  ");

		do
		{
			printf("\nEnter parent node :");
			scanf("%d", &parent);
			do
			{
				printf("\nEnter adjacent node for node %d : ", parent);
				scanf("%d", &adj_parent);
				adj[parent][adj_parent]=1;
				adj[adj_parent][parent]=1;
				printf("\nContinue to add adjacent node for %d (1/0)?", parent);
				scanf("%d", &ans1);
			} while (ans1==1);
			printf("\nContinue to add graph node?");
			scanf("%d", &ans);
		}while (ans ==1);

		printf("\nAdjacency matrix for your graph is :\n");
		for (i=1;i<=n;i++)
		{
			for (j=1;j<=n;j++)
				printf("%d  ", adj[i][j]);
			printf("\n");
		}

		printf("\nEnter the initial node for DFS traversal:");
		scanf("%d", &initial_node);
		DFS (initial_node, n);
	}

	int main()
	{
		createGraph();
        return 0;
	}