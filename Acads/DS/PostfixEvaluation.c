#include <stdio.h>
#include <ctype.h>
int size = 50, top = -1, i = 0;
char c[50];
float f[50];

void push(float fl)
{
    if (top == size - 1)
        printf("Reached max size!");
    else
    {
        top++;
        f[top] = fl;
    }
}

float pop()
{
    if (top == -1)
    {
        printf("Stack is empty!");
        return 0.0;
    }
    else
    {
        float temp = f[top];
        top--;
        return temp;
    }
}

void display()
{
    printf("%f", f[top]);
}

void eval()
{
    while (c[i] != '\0')
    {
        if (isdigit(c[i]))
            push((float)(c[i] - '0'));
        else
        {
            float f1 = pop();
            float f2 = pop();
            float ans = 0.0;
            switch (c[i])
            {
            case '+':
                ans=f2 + f1;
                push(ans);
                break;
            case '-':
                ans=f2 - f1;
                push(ans);
                break;
            case 'x':
                ans=f2 * f1;
                push(ans);
                break;
            case '/':
                ans=f2 / f1;
                push(ans);
                break;
            default:
                break;
            }
        }
        i++;
    }
}
int main()
{
    printf("Enter the postfix expression:");
    scanf("%s", c);
    eval();
    display();
    return 0;
}
