/* Read input from STDIN. Print your output to STDOUT*/
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <vector>

using namespace std;

int main(int argc, char *a[])
{
    int length, j = 0, T, temp = 0;
    std::vector<int> heroes, villains;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> length;

        for (j = 0; j < length; j++)
        {
            cin >> temp;
            villains.push_back(temp);
        }

        for (j = 0; j < length; j++)
        {
            cin >> temp;
            heroes.push_back(temp);
        }

        sort(heroes.begin(), heroes.end());
        sort(villains.begin(), villains.end());

        for (j = 0; j < length; j++)
            if (heroes[j] < villains[j])
                break;

        if (j == length)
            cout << "WIN\n";
        else
            cout << "LOSE\n";
    }
}
