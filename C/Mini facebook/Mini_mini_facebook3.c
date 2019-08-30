#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX 20

typedef struct
{
    char *name;
    //can add as much profile details as we want
} user;

user users[MAX]; //user list
int relationMat[MAX][MAX];
int visited[MAX];
int stack[MAX];

int numbOfUsers = 0;
int stackTop = -1, usersIndex = -1;

void push(int item)
{
    if (stackTop == MAX)
        printf("Stack overflow");
    else
        stack[++stackTop] = item;
}

int pop()
{
    if (stackTop == -1)
    {
        printf("Stack underflow");
        return 0;
    }
    else
        return (stack[stackTop--]);
}

void addUser(char _name[]) //add user to Users' database.
{

    usersIndex++;
    numbOfUsers++;
    users[usersIndex].name = strdup(_name);
}

void displayFriends()
{
    int i = 0, j = 0;

    for (i = 0; i < numbOfUsers; i++)
    {
        printf("\n\n\t\t%s: ", users[i].name);
        for (j = 0; j < numbOfUsers; j++)
        {
            if (relationMat[i][j] == 1)
                printf("\t%s ", users[j].name);
        }
    }
}

void listAllUsers() //DFS traversal in order to display friends list
{
    int u, i;
    int initial_node = 0;
    stackTop = -1;
    push(initial_node);
    printf("\n\n\t\t");
    while (stackTop >= 0)
    {
        u = pop();
        if (visited[u] == 0)
        {
            printf("%s, ", users[u].name);
            visited[u] = 1;
        }
        for (i = 0; i < numbOfUsers; i++)
        {
            if ((relationMat[u][i] == 1) && (visited[i] == 0))
            {
                push(u);
                visited[i] = 1;
                printf("%s\t ", users[u].name);
                u = i;
            }
        }
    }
}

void addFriend(int user, int friend) //create relations graph.
{
    if (user > 0 && friend > 0 && user <= MAX && friend <= MAX)
    {
        if (relationMat[user - 1][friend - 1] == 1)
            printf("They are already friends!");
        else
            relationMat[user - 1][friend - 1] = 1;
    }
    else
        printf("Invalid input!");
}

void unfriend(int user, int friend) //create relations graph.
{
    if (user > 0 && friend > 0 && user <= MAX && friend <= MAX)
    {
        if (relationMat[user - 1][friend - 1] == 0)
            printf("They are not friends!");
        else
            relationMat[user - 1][friend - 1] = 0;
    }
    else
        printf("Invalid input!");
}

void mutualFriend(int friend1, int friend2)
{
    int i = 0, j = 0, count = 0;
    int temp[20];

    for (i = 0; i < numbOfUsers; i++)
    {
        if (relationMat[friend1][i] == 1 && relationMat[friend2][i] == 1 && friend1 != i && friend2 != i)
        {

            temp[count] = i;
            count++;
        }
    }
    if (count == 0)
        printf("\t\tNo mutual friends!");
    else
    {
        printf("\t\tMutual friends of %s and %s are: ", users[friend1].name, users[friend2].name);
        for (i = 0; i < count; i++)
            printf("%s, ", users[temp[i]].name);
    }
}

void fordelay(int j)
{
    int i, k;
    for (i = 0; i < j; i++)
        k = i;
}

void menu()
{
    int choice, user1, friend1, friend2, c = 1, d, friend_counter = 0, count = 0;
    char name[20];
    system("cls");
    system("color 9");
    printf("\n\n\t\t\t\tMINI FACEBOOK");
    printf("\n\n\n\t\t\t\xB2\xB2\xB2\xB2\xB2\xB2\xB2 WELCOME TO THE MAIN MENU \xB2\xB2\xB2\xB2\xB2\xB2\xB2");
    printf("\n\n\t\t1.ADD USER\n\t\t2.ADD A FRIEND FOR A USER\n\t\t3.UNFRIEND\n\t\t4.SEE FRIENDS OF A USER\n\t\t5.CHECK MUTUAL FRIENDS\n\t\t6.List All Users\n\t\t7. xit\n\n\n\n\n\t\t Enter your choice:");
    scanf("%d", &choice);
    if (choice == 7)
        system("color 7");
    system("cls");
    switch (choice)
    {
    case 1:
        for (int i = 0; i < numbOfUsers; i++)
        {
            printf("\n\t\t%d.%s\n", i + 1, users[i].name);
        }
        printf("\n\n\t\tEnter name %d: ", numbOfUsers + 1);
        scanf("%s", name);
        addUser(name);
        printf("\n\n\t\tAdding User");
        for (int i = 0; i <= 6; i++)
        {
            fordelay(100000000);
            printf(".");
        }
        printf("\n\n\t\tUser Added");
        fordelay(100000000);
        system("cls");
        menu();
        break;
    case 2:
        for (int i = 0; i < numbOfUsers; i++)
        {
            printf("\n\t\t%d.%s\n", i + 1, users[i].name);
        }
        printf("\n\n\t\tEnter the user you want to add friends for:");
        scanf("%d", &user1);
        system("cls");
        for (int i = 0; i < numbOfUsers; i++)
        {
            if (i == user1 - 1)
                continue;
            else
            {
                printf("\n\n\t\t%d.%s", i + 1, users[i].name);
            }
        }
        do
        {
            printf("\n\n\t\tEnter the friends:");
            scanf("%d", &friend1);
            addFriend(user1, friend1);
            printf("\n\n\t\t%s is now friend with %s", users[user1 - 1].name, users[friend1 - 1].name);
            printf("\n\n\t\tDo you want to add more friends ? (1/0)");
            scanf("%d", &c);
        } while (c != 0);
        system("cls");
        menu();
        break;
    case 3:
        c = 1;
        for (int i = 0; i < numbOfUsers; i++)
        {
            printf("\n\t\t%d.%s", i + 1, users[i].name);
        }
        printf("\n\n\t\tEnter the user you want to remove friends for:");
        scanf("%d", &user1);
        system("cls");
        for (int j = 0; j < numbOfUsers; j++)
        {
            if (relationMat[user1 - 1][j] == 1)
            {
                count++;
                break;
            }
        }
        if (count != 0)
        {
            printf("\n\n\t\tBelow are the friends of %s\n", users[user1 - 1].name);
            for (int j = 0; j < numbOfUsers; j++)
            {
                if (relationMat[user1 - 1][j] == 1)
                    printf("\n\t\t%d.%s", j + 1, users[j].name);
            }
            count = 0;
            do
            {
                printf("\n\n\t\tEnter the friend to remove:");
                scanf("%d", &friend1);
                unfriend(user1, friend1);
                printf("\n\t\tDo you want to remove more friends ? (1/0)");
                scanf("%d", &c);
            } while (c != 0);
        }
        else
            printf("No friends!");
        system("cls");
        menu();
        break;
    case 4:
        displayFriends();
        printf("\n\n\t\tEnter 1 to go back to Main Menu or 0 to exit:");
        scanf("%d", &d);
        if (d == 1)
        {
            system("cls");
            menu();
        }
        break;
    case 5:
        for (int i = 0; i < numbOfUsers; i++)
        {
            printf("\n\n\t\t%d.%s\n", i + 1, users[i].name);
        }
        printf("\n\n\t\tEnter the two users you want to check mutual friends for:");
        scanf("%d %d", &friend1, &friend2);
        mutualFriend(friend1 - 1, friend2 - 1);
        printf("\n\n\t\tEnter 1 to go back to Main Menu or 0 to exit:");
        scanf("%d", &d);
        if (d == 1)
        {
            system("cls");
            menu();
        }
        break;
    case 6:
        listAllUsers();
        printf("\n\n\t\tEnter 1 to go back to Main Menu or 0 to exit:");
        scanf("%d", &d);
        if (d == 1)
        {
            system("cls");
            menu();
        }
        break;
    case 7:
        printf("Exiting!");
        break;
    }
}

int main()
{
    int n;
    char name[20];
    int i = 0, j = 0, k = 0;
    for (i = 0; i < MAX; i++)
    {
        for (j = 0; j < MAX; j++)
            relationMat[i][j] = 0;
    }
    system("cls");
    system("color 9");
    printf("\n\n\n\t\t\t\t\tWELCOME");
    for (int i = 0; i <= 6; i++)
    {
        fordelay(100000000);
        printf(".");
    }
    system("cls");
    printf("\n\n\t\t\t\tMINI FACEBOOK");
    printf("\n\n\t\tENTER THE NUMBER OF USERS: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        printf("\n\t\tEnter name %d: ", i + 1);
        scanf("%s", name);
        addUser(name);
    }
    menu();
    return 0;
}