#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>

using namespace std;

int main(int argc, char *a[])
{
    int length, T, max, finalMax = -12000, tempPar = 0, temp;
    std::vector<int> tickets, dpArr, ans, parent;

    cin >> T;

    while (T--)
    {
        dpArr.clear();
        tickets.clear();
        ans.clear();
        parent.clear();

        finalMax = -12000;
    
        cin >> length;
        for (int j = 0; j < length; j++)
        {
            cin >> temp;
            tickets.push_back(temp);
        }

        for (int j = 0; j < length; j++)
        {
            dpArr.push_back(0);
            ans.push_back(0);
            parent.push_back(-1);
        }

        dpArr[length - 1] = tickets[length - 1];
        dpArr[length - 2] = tickets[length - 2];
        parent[length - 1] = -1;
        parent[length - 2] = -1;
        for (int j = length - 3; j >= 0; j--)
        {
            max =  -1;
            tempPar = 0;

            for (int k = j + 2; k < length; k++)
            {
                if (dpArr[k] > max)
                {
                    max = dpArr[k];
                    tempPar = k;
                }
            }
            if (max < 0)
            {
                dpArr[j] = tickets[j];
                parent[j] = -1;
            }
            else{
                dpArr[j] = max + tickets[j];
                parent[j] = tempPar;
            }
        }
        int k = 0;        
        for (int j = 0; j < length; j++)
        {
            if (dpArr[j] > finalMax)
            {
                finalMax = dpArr[j];
                k = j;
            }
        }
        //cout << "Max pos: " << k << "\n";

        while (parent[k] != -1)
        {
            ans.push_back(tickets[k]);
            k = parent[k];
        }
        ans.push_back(tickets[k]);

        for (int l = ans.size() - 1; l >= 0; l--)
        {
            if (ans[l] != 0)
                cout << ans[l];
        }
        cout << "\n";
    }
}