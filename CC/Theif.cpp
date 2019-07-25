#include <algorithm>
#include <iostream>
using namespace std;

int main() {
  int T, t;
  unsigned long int N, s, h, temp, *money, *outps, *outph;

  cin >> T;
  t = 0;
  outph = new unsigned long int[T];
  outps = new unsigned long int[T];
  while (t<T) {
    cin >> N;
    h = N - 1;
    s = 0;
    money = new unsigned long int[N];
    for (int i = 0; i < N; i++)
      cin >> money[i];

    while (h >= s) {
      if (money[h] > money[s]) {
        temp = 2 * money[h];
        temp -= money[s];
        while (temp > 0 && h != s) {
          if (temp >= money[s]) {
            temp -= money[s];
            money[s] = 0;
            s++;
          } else {
            temp = 0;
            money[s] -= temp;
          }
        }
        h--;
      } else {
        temp = (int)(money[s] / 2);
        while (temp > 0 && h != s) {
          if (temp >= money[h]) {
            temp -= money[h];
            money[h] = 0;
            h--;
          } else {
            temp = 0;
            money[h] -= temp;
          }
        }
        s++;
      }
    }

    outps[t] = s;
    outph[t] = N - h - 1;
    t++;
  }  
  for (int i = 0; i < T; i++) {
    cout << outps[i] << ' ' << outph[i] << endl;
    if (outph[i] > outps[i])
      cout << "Henil" << endl;
    else
      cout << "Sanjana" << endl;
  }
  return 0;
}