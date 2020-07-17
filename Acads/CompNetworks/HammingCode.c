//GENERIC CODE FOR HAMING CODE
#include <stdio.h>
#include <math.h>

static int parities[100], signal[150];

int isPower(int x)
{
    double d = log((double)x) / log((double)2);
    int d1 = (int)d;
    double checker = d - d1;
    if (checker == 0.0)
        return 1;
    return 0;
}

void parityPos(int pos, int parityBits)
{
    int count = 1, curr = pos;

    while (curr <= parityBits)
    {
        for (int i = 1; i <= pos; i++)
        {
            if (curr <= parityBits)
            {
                parities[count] = curr;
                count++;
                if (i != pos)
                    curr++;
            }
            else
                break;
        }
        if (curr <= parityBits)
            curr += (pos + 1);
        else
            break;
    }
}

void insertParityBit(int pos, int pars[])
{
    int i = 1, count = 0;
    while (pars[i] != 0)
    {
        if (signal[pars[i]] == 1)
            count++;
        //printf("%d, ", signal[pars[i]]);
        i++;
    }
    if (count % 2 == 0)
        signal[pos] = 0;
    else
        signal[pos] = 1;
    /* xor = signal[1] ^ signal[pars[2]];
    while (pars[i] != 0)
    {
        xor = xor^signal[pars[i]];
        i++;
    }
    if (xor == 0) //even
        signal[pos] = 0;
    else
        signal[pos] = 1;*/
}

void parityChecker(int n)
{
    int j = 1, count = 0;
    for (int i = n; i >= 1; i--)
    {
        if (isPower(i))
        {
            parityPos(i, n);
            j = 1;
            count = 0;
            while (parities[j] != 0)
            {
                if (signal[parities[j]] == 1)
                    count++;
                j++;
            }
            if (count % 2 == 1)
                printf("\nERROR DETECTED AT POSITION: %d", i);
        }
    }
    printf("\n");
}

int main()
{
    int r, mes[50], m = 0, opt = 1;

    do
    {
        printf("\nEnter\n1 for Haming Code checker\n2 for Haming Code Generator:\n0 to exit\n");
        scanf("%d", &opt);
        switch (opt)
        {
        case 0:
            break;
        case 2:
            printf("\nEnter the no. of bits: ");
            scanf("%d", &m);

            printf("Enter the bits:\n");
            for (int i = 1; i <= m; i++)
                scanf("%d", &mes[i]);

            r = 0;
            while ((pow(2, r) - r - 1) < (double)m)
                r++;

            int mesCnt = 1;
            for (int i = m + r; i >= 1; i--)
            {
                if (!isPower(i))
                {
                    signal[i] = mes[mesCnt];
                    mesCnt++;
                }
                else
                {
                    signal[i] = 999;
                    parityPos(i, m + r);
                    insertParityBit(i, parities);
                }
            }
            printf("Haming Code:\n");
            for (int i = m + r; i >= 1; i--)
                printf("%d", signal[i]);
            printf("\n");
            break;
        case 1:
            printf("\nEnter the no. of final bits to be checked: ");
            scanf("%d", &m);

            printf("Enter the bits:\n");
            for (int i = m; i >= 1; i--)
                scanf("%d", &signal[i]);

            parityChecker(m);
            break;
        }
    } while (opt != 0);
    return 0;
}