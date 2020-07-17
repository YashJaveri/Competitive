#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <string.h>

//Infix to postfix
#define MAX 50

char stack[MAX], inp[MAX], postfix[MAX], rev[MAX];
int top_Stack = -1, top_postfix = -1; //for stack

void pushPostfix(char x)
{
    top_postfix += 1;
    postfix[top_postfix] = x;
}
void pushStack(char y)
{
    if (top_Stack != MAX - 1)
    {
        top_Stack += 1;
        stack[top_Stack] = y;
    }
}

int popStack()
{
    if (top_Stack != -1)
    {
        int a = stack[top_Stack];
        top_Stack -= 1;
        return a;
    }
    else
        return 0;
}

int precedence(char c)
{
    if (c == '(')
        return 0;
    else if (c == '+' || c == '-')
        return 1;
    else if (c == '*' || c == '/')
        return 2;
    else if (c == '%')
        return 3;
    else
        return -1;
}

void displayAnswer(char d[])
{
    int i = 0;
    printf("Here's the answer:");
    for (i = 0; d[i] != '\0'; i++)
        printf("%c", d[i]);
    printf("\n");
}

void stringrev(char a[])
{
    int count = 0, i = 0;
    memset(rev, 0, strlen(rev)); //to clear(empty..) the string "rev".
    count = strlen(a);
    for (i = 0; i < count; i++)
    {
        if (a[count - i - 1] == '(')
            rev[i] = ')';
        else if (a[count - i - 1] == ')')
            rev[i] = '(';
        else
            rev[i] = a[count - i - 1];
    }
    i++;
    rev[i] = '\0';
}

int main()
{
    char x, y = 'y';
    int i = 0;
    printf("Enter the Infix equation:");
    gets(inp);

    stringrev(inp);
    displayAnswer(rev);
    while (rev[i] != '\0')
    {
        x = rev[i];
        if (isalnum(x))
        {
            pushPostfix(x);
            i++;
        }
        else if (x == '(')
        {
            pushStack(x);
            i++;
        }
        else if (x == ')')
        {
            while ((y = popStack()) != '(' && top_Stack != -1)
                pushPostfix(y);
            i++;
        }
        else if (x == '+' || x == '-' || x == '*' || x == '/' || x == '%')
        {
            while (top_Stack != -1 && precedence(x) <= precedence(stack[top_Stack]) && stack[top_Stack] != '(')
            {
                y = popStack();
                pushPostfix(y);
            }
            pushStack(x);
            i++;
        }
        else
        {
            printf("Invalid input, you fool!");
        }
    }
    while (top_Stack != -1 && stack[top_Stack] != '(')
    {
        y = popStack();
        pushPostfix(y);
    }
    postfix[top_postfix + 1] = '\0';
    displayAnswer(postfix);
    stringrev(postfix);
    displayAnswer(rev);
    return 0;
}