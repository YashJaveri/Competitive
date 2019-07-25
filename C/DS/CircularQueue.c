#include <stdio.h>
#include <stdlib.h>

#define MAX 5

int circularQueue[10];
int rear = -1, front = -1;

void enquue(int val)
{
    if ((rear + 1) % MAX == front)
        printf("->OVERFLOW!!\n");
    else if (front == -1)
    {
        front = rear = 0;
        circularQueue[rear] = val;
    }
    else
    {
        rear = (rear + 1) % MAX;
        circularQueue[rear] = val;
    }
}

int deque()
{
    if (front == -1)
    {
        printf("->UNDERFLOW!!\n");
        return 0;
    }
    else if (front == rear)
    {
        int temp = circularQueue[front];
        front = rear = -1;
        return temp;
    }
    else
    {
        int temp = circularQueue[front];
        front = (front + 1) % MAX;
        return temp;
    }
}

void display()
{
    int i = front;
    if (i == -1)
        printf("->Queue is empty!!");
    else
    {
        printf("%d, ", circularQueue[i]);
        do
        {
            i = (i + 1) % MAX;
            printf("%d, ", circularQueue[i]);
        } while (i != rear);
        printf("\n");
    }
}

int main()
{
    int a = 0, val = 0, t = 0;

    do
    {
        printf("----MAIN MENU----\nEnter 1 to enque\t2 to deque\t3 to display\t0 to exit: ");
        scanf("%d", &a);
        switch (a)
        {
        case 0:
            printf("Exiting!\n");
            break;
        case 1:
            printf("Enter the value to be entered:\n");
            scanf("%d", &val);
            enquue(val);
            break;
        case 2:
            t = deque();
            if (t != 0)
                printf("Deleted number was %d\n", t);
            break;
        case 3:
            display();
            break;
        default:
            printf("Exiting!\n");
            break;
        }
    } while (a != 0);

    return 0;
}
