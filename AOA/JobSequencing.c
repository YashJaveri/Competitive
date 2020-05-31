#include <stdio.h>

#define MAX 100

struct Job
{
    char id[5];
    int deadline;
    int profit;
};

struct Job temp;

int dmax = 0, maxprofit = 0;
int timeSlot[MAX];

void jobSequencingWithDeadline(struct Job jobs[], int n)
{
    int i, j, k;

    int filledSlots = 0;
    for (i = 0; i < n; i++)
    {
        if (jobs[i].deadline > dmax)
        {
            dmax = jobs[i].deadline;
        }
    }

    for (i = 1; i <= dmax; i++)
        timeSlot[i] = -1;
    printf("dmax: %d\n", dmax);

    for (i = 0; i < n; i++)
    {
        k = jobs[i].deadline;
        while (k >= 1)
        {
            if (timeSlot[k] == -1)
            {
                timeSlot[k] = i;
                filledSlots++;
                break;
            }
            k--;
        }

        if (filledSlots == dmax)
        {
            break;
        }
    }
}

int main()
{
    int i, j;

    //jobs with deadline and profit
    struct Job jobs[20] = {
        {"j1", 2, 30},
        {"j2", 1, 80},
        {"j3", 3, 40},
        {"j4", 2, 25},
        {"j5", 1, 30},
    };

    //number of jobs
    int n = 5;

    //sort the jobs profit wise in descending order
    for (i = 0; i < n - 1; i++)
    {
        for (j = i; j < n; j++)
        {
            if (jobs[j + 1].profit > jobs[j].profit)
            {
                temp = jobs[j + 1];
                jobs[j + 1] = jobs[j];
                jobs[j] = temp;
            }
        }
    }
    printf("%s %10s %10s\n", "Job", "Deadline", "Profit");
    for (i = 0; i < n; i++)
        printf("%3s %10d %10d\n", jobs[i].id, jobs[i].deadline, jobs[i].profit);

    jobSequencingWithDeadline(jobs, n);
    printf("\nRequired Jobs: ");
    for (i = 1; i <= dmax; i++)
    {
        printf("%s", jobs[timeSlot[i]].id);

        if (i < dmax)
        {
            printf(" --> ");
        }
    }

    maxprofit = 0;
    for (i = 1; i <= dmax; i++)
    {
        maxprofit += jobs[timeSlot[i]].profit;
    }
    printf("\nMax Profit: %d\n", maxprofit);

    return 0;
}