#include <iostream>
#include <string.h>
#include <algorithm>
#include <cmath>
#include <bits/stdc++.h>

using namespace std;

char space = ' ';
long int T, size, N, length, mcount = 1, finalPrimeCounter, finalUnsortedPrimeCounter, firstPrime, secondPrime;
long int inp[100], finalPrimes[26], finalUnsortedPrimes[100];

vector<string> L;
long int *primes;

bool primeFlag = true, firstPrimeFound = false;

bool contain(long int num)
{
    for (int k = 0; k < finalPrimeCounter; k++)
    {
        if (finalPrimes[k] == num)
            return true;
    }
    return false;
}

int binarySearch(long int arr[], int l, int r, int x)
{
    if (r >= l)
    {
        int mid = l + (r - l) / 2;

        // If the element is present at the middle
        // itself
        if (arr[mid] == x)
            return mid;

        // If element is smaller than mid, then
        // it can only be present in left subarray
        if (arr[mid] > x)
            return binarySearch(arr, l, mid - 1, x);

        // Else the element can only be present
        // in right subarray
        return binarySearch(arr, mid + 1, r, x);
    }

    // We reach here when element is not
    // present in array
    return -1;
}

int main()
{
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> N;
        cin >> length;

        for (int j = 0; j < length; j++)
            cin >> inp[j];

        primes = new long int(inp[0] / 2);
        primes[0] = 2;
        mcount = 1;

        for (int j = 3; j <= (N / 2) + 1; j++)
        {
            for (int k = 2; k < j; k++)
            {
                if (j % k == 0)
                {
                    primeFlag = false;
                    break;
                }
            }
            if (primeFlag)
            {
                primes[mcount] = j;
                //cout << "Prime: " << j << ", ";
                mcount += 1;
            }
            primeFlag = true;
        }

        for (int j = 0; j < mcount + 1; j++)
        {
            if (firstPrimeFound)
                break;
            for (int k = j; k < mcount + 1; k++)
            {
                if (primes[k] * primes[j] == inp[0])
                {
                    firstPrimeFound = true;
                    firstPrime = primes[j];
                    secondPrime = primes[k];
                    break;
                }
                if (primes[j] * primes[k] > inp[0])
                    break; //no need to check further
            }
        }

        if (inp[1] % firstPrime == 0)
        {
            long int temp = secondPrime;
            secondPrime = firstPrime;
            firstPrime = secondPrime;
        }
        finalPrimeCounter = 2; //size
        finalUnsortedPrimeCounter = 2;
        finalPrimes[0] = firstPrime;
        finalPrimes[1] = secondPrime;
        finalUnsortedPrimes[0] = firstPrime;
        finalUnsortedPrimes[1] = secondPrime;

        for (int j = 1; j < length; j++)
        {
            //cout << "inp: " << inp[j] << " ";
            long int num = (long int)((float)inp[j] / (float)finalUnsortedPrimes[finalUnsortedPrimeCounter - 1]);
            //cout << "Final unsorted prime: " << finalUnsortedPrimes[finalUnsortedPrimeCounter - 1] << " ";
            //cout << "num: " << num << " ";
            finalUnsortedPrimes[finalUnsortedPrimeCounter] = num;
            finalUnsortedPrimeCounter += 1;
            //cout << "Final Counter: " << finalUnsortedPrimeCounter << endl;
            //check if num is already there?
            if (!contain(num))
            {
                finalPrimes[finalPrimeCounter] = num;
                finalPrimeCounter += 1;
            }
        }

        sort(finalPrimes, finalPrimes + 26);

        cout << "Case #" << i + 1 << ": ";
        for (int j = 0; j < finalUnsortedPrimeCounter; j++)
        {
            int index = binarySearch(finalPrimes, 0, 25, finalUnsortedPrimes[j]);
            cout << (char)(65 + index);
        }
        cout << endl;
    }
    return 0;
}