'''You are given the rating of n chess players sorted according to their standings in a recent tournament in an array.
You are supposed to summarize the performance by calculating the following metrics for each player i,
f(i) = number of players after i with rating less than player[i]
g(i) = number of players before i with rating less than player[i]
h(i) = number of players after i with rating more than player[i]
k(i) = number of players before i with rating more than player[i]

We also define F(i) = f(i)+g(i)+h(i)+k(i)
And therefore summary G = F(1)+F(2)+F(3)+...+F(n)
You have to print G, which is the summary of the tournament.

Input Format
The first line of the input consists of an integer N denoting the number of players
The second line of the input consists of N elements each denoting the rating of the N players, according to their standings in a recent tournament

Constraints
2 <= N <= 105
0 <= rating[i] <= 100

Output Format
Print a single integer G denoting the overall summary of the tournament'''

n = int(input())
inpArrStr = input().split()
inpArr = [int(x) for x in inpArrStr]
inpArr.sort()

ans = (n-1)*n
count=0
mdict = {}

for i in range(0, n):
    if inpArr[i] in mdict:
        mdict[inpArr[i]] += 1
    else:
        mdict[inpArr[i]] = 1
#print(mdict)
for k, v in mdict.items():
    if v>1:
        count += v*(v-1)

print(ans-count)