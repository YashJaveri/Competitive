f = open("Sample.txt", "r")

content = f.read()
sArr = content.split(' ')

mDict = {}

print(sArr)

for w in sArr:
    if w in mDict:
        mDict[w] += 1
    else:
        mDict[w] = 1

print(mDict)
f.close()