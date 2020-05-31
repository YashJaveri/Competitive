def buildLowestNumber(min):
    str1 = str(min)
    for i in range(0, len(str1)):
        strObj = str1[0: i:] + str1[i + 1::]
        temp = int(strObj)
        if min>temp:
            min = temp
    print(min)

T = int(input())

for i in range(0, T):
    x = int(input())    
    buildLowestNumber(x)