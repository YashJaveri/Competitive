inp = []
mdict = {} 
flag = 0

inpStr = input()
inpArr = inpStr.split()

for e in inpArr:
    mdict[e] = 0 

for e in inpArr:
    mdict[e] += 1 

for e in mdict.values():
    if e%2!=0:
        flag = 1
        print("NO")
        break

if flag==0:
    print("YES")