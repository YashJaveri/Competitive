''''Alice gives Bob an unformatted key in the form of string S and a number K.
S consists only alphanumeric characters and dashes and is separated into N+1 groups by N dashes.
Bob has to re-format S in such a way that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character.
Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.'''
import os
import sys


def formatTheKey(S, K):
    # Write your code here    
    arr = S.split('-')
    mStr = ""
    ans  = ""
    
    for s in arr:
        mStr += s    
    
    count = 0
    for i in reversed(range(len(mStr))):
        ans+=mStr[i]
        count+=1
        if count%K==0:
            ans+='-'
    ans = ans.upper()[::-1]
    if ans[0] == '-':
        ans = ans[1:]
        
    return ans


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    S = input()

    K = int(input().strip())

    result = formatTheKey(S, K)

    fptr.write(result + '\n')

    fptr.close()