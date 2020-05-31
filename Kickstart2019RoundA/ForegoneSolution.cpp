#include <iostream>
#include <string.h>

using namespace std;

int main()
{
   string N, ans, ansf;
   int T = 0, var;
   bool b = false, k = 0;

   cin >> T;

   for (int j = 0; j < T; j++)
   {
      cin >> N;
      ans = N;
      for (int i = 0; i < N.length(); i++)
      {
         if (N[i] == '4')
         {
            N[i] = '3';
            ans[i] = '1';
         }
         else
         {
            ans[i] = '0';
         }
      }
      for (int i = 0; i < ans.length(); i++)
      {
         if (ans[i] == '1')
         {
            var = i;
            break;
         }
      }
      ansf = ans.substr(var, ans.length());
      cout << "Case #" << j + 1 << ": " << N << " " << ansf << endl;
   }
   return 0;
}
