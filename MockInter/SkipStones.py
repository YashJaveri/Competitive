'''You are playing a game called Skipping Stones in Takeshi's Castle.Some of the stones are not fixed and stepping on that will make you lose the game immediately. You have got the information about the stones that are fixed and those that are moving. The moving stones are represented by 1 while the fixed one are represent by 0. You can jump on any fixed stone having a number that is equal to the number of the current stone plus 1 or 2.
Find the min jumps required to reach from first to last stone.
Note: It is always possible to win the game.

Input Format
The first line contains an integer n denoting the number of stones.
The next line contains n integers 0 or 1 denoting whether the stone is fixed or moving.

Constraints
2 <= n <= 100
c[i] = 0 OR 1

1st and last elements are 0 to always find a solution

Output Format
Print the minimum number of jumps needed to win the game.

Sample Input 0
7
0 0 1 0 0 1 0
Sample Output 0
4'''

n = int(input())
arrStr = input().split(' ')

arrInp = [int(x) for x in arrStr]

i=0
count = 0

while i<len(arrInp):
    if(i == len(arrInp) - 1):
        break
    if(i == len(arrInp)-2):
        if arrInp[i+1] == 0:
            count += 1
            break
    if(arrInp[i+2] == 0):
        i = i+2
        count+=1
    elif(arrInp[i+1] == 0):
        i+=1
        count+=1
print(str(count))