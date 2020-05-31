#include <stdio.h>

char c[50];
int top = -1, i = 0, size = 50, front = -1;

void enqueue(char a)
{
    if (top == size - 1)
        printf("Size limit exceeded!");
    else if (top == -1)
    {
        front++;
        top++;
        c[top] = a;
    }
    else
    {
        top++;
        c[top] = a;
    }
}

void dequeue()
{
    if (top == -1)
        printf("Queue is empty!\n");
    else if (front == top)
    {
        front = -1;
        top = -1;
    }
    else
        front++;
}

void display()
{
    printf("Queue is:");
    for (int j = front; j <= top; j++)
        printf("%d,", c[j]);
    printf("\n");
}
int main()
{
    int a = 0, b = 0;
    while (a != 2)
    {
        printf("Enter 0 to push, 1 to pop, 2 to exit, 3 to display");
        scanf("%d", &a);
        switch (a)
        {
        case 0:
            printf("Enter number to push:");
            scanf("%d", &b);
            enqueue(b);
            break;
        case 1:
            dequeue();
            break;
        case 3:
            display();
            break;
        case 2:
            break;
        }
    }
    return 0;
}