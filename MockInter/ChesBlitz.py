n = int(input())
inpArrStr = input().split()
inpArr = [int(x) for x in inpArrStr]
#inpArr.sort()

ans = (n-1)*n
count=0
s = set(inpArr)
mdict = dict((x, inpArr.count(x)) for x in s)


#print(mdict)
for k, v in mdict.items():    
        count += v*(n-v)

print(count)