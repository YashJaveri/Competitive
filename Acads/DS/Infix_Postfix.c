#include <stdio.h>
#include <string.h>
#include <ctype.h>

//Infix to Postfix

char stack[100], inp[100], postfix[100];
int top_Stack = -1, top_Postfix = -1; //for stack

void pushPostfix(char x)
{
    top_Postfix += 1;
    postfix[top_Postfix] = x;
}
void pushStack(char y)
{
    top_Stack += 1;
    stack[top_Stack] = y;
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
    {
        return 0;
    }
}

int precedence(char c)
{
    if (c == '+' || c == '-')
        return 1;
    else if (c == '*' || c == '/')
        return 2;
    else if (c == '(')
        return 0;
    else if (c == '%')
        return 3;
    else
    {
        //printf("Invalid");
        return -1;
    }
}

void displayAnswer()
{
    int i = 0;
    for (i = 0; postfix[i] != '\0'; i++)
        printf("%c", postfix[i]);
}

int main()
{
    char x, y = 'y';
    int i = 0;

    printf("Enter the Infix equation:");
    gets(inp);

    while (inp[i] != '\0')
    {
        x = inp[i];
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
            {
                pushPostfix(y);
            }
            i++;
            if (top_Stack == -1)
            {
                printf("Invalid expression!");
            }
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
    postfix[top_Postfix + 1] = '\0';
    displayAnswer();
    return 0;
}