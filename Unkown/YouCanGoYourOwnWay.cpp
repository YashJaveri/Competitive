#include <iostream>
#include <string.h>
#include <algorithm>

using namespace std;

int main()
{
   string inp, ans;   
   int size=0, T = 0;   

   cin >> T;
   for (int i = 0; i < T; i++)
   {
      cin >> size;      
      cin >> inp;
      std::replace(inp.begin(), inp.end(), 'S', 'X');
      std::replace(inp.begin(), inp.end(), 'E', 'S');
      std::replace(inp.begin(), inp.end(), 'X', 'E');
      cout <<"Case #"<<i + 1<< ": "<<inp<<endl;                  
   }
   return 0;
}