#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n, m, flag = 0;
    string inp;
    int r[101];

        cin>>n>>m;
        cin>>inp;
        flag=0;
        for(int i=0; i<27; i++)
            r[i] = 0;
        for(int i=0; i<inp.length(); i++){
            r[(int)inp[i] - 97]+=1;  
            if(r[(int)inp[i] - 97] > m)
            {
                flag = 1;
                break;
            }
        }

        if(flag==1)
            cout<<"NO";
        else
            cout<<"YES";

    return 0;
}