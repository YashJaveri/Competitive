#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <algorithm>
#include <vector>

using namespace std;

int main(int argc, char *a[])
{
    unsigned int length, T, temp, finalMax, k, selected, flag = 0;
    std::vector<unsigned int> inp, max, finalArr, included;

    cin >> T;

    while (T--)
    {
        inp.clear();
        max.clear();

        cin >> length;
        for (int i = 0; i < length; i++)
        {
            cin >> temp;
            inp.push_back(temp);
        }

        sort(inp.begin(), inp.end(), greater<int>());

        for (int i = 0; i < length; i++)
        {
            max.push_back(inp[i]);
            included.push_back(inp[i]);

            for (int j = 0; j < length; j++)
            {
                selected = inp[j], flag = 0;            
                if (j == i)
                    continue;
                if (flag == 1)
                    break;
                else                
                {
                    //str compare
                    for (int m = 0; m < included.size(); m++)
                    {
                        unsigned int curr = included[m];

                        string selectedStr = to_string(selected);
                        string currStr = to_string(curr);

                        for (int k = 0; k < selectedStr.length(); k++)
                        {
                            if (flag == 1)
                                break;

                            for (int l = 0; l < currStr.length(); l++)
                            {
                                //cout << "For i:" << inp[i] << " selectedStr: " << selectedStr << " selectedStr(" << k << "): " << selectedStr[k] << " currStr: " << currStr << " currStr(" << l << "): " << currStr[l] << "\n";
                                if (selectedStr.at(k) == currStr.at(l))
                                {
                                    flag = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
                //no match, so include
                if (flag == 0)
                {
                    max[i] += inp[j];
                    //cout << "pushing for i " << inp[i] << " value: " << inp[j] << ",\n";
                    included.push_back(inp[j]);
                }
            }
            included.clear();
        }

        finalMax = max[0];
        for (int i = 1; i < length; i++)
        {
            if (finalMax < max[i])
                finalMax = max[i];
        }

        cout << finalMax << "\n";
    }
}
