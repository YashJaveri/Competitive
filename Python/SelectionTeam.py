#KickstartCC2019 practice question

mDict = {}
ansArr = []

p = 0
n = 0

t = int(input("Enter testCases: "))

for k in range(0, t):
    ansArr, intArr = [], [] #clear
    cutTupple, sortedTupple = (), () #clear

    n = int(input("Enter n: "))
    p = int(input("Enter p: "))
    if 2<n<100000 and 2<p<n :

        strArr = input("Enter skills: ").split(" ")
        intArr = list(map(int, strArr))

        if len(intArr) is n:
            intArr.sort()
            for i in range(0, len(intArr)-1):
                mDict[i] = abs(intArr[i+1] - intArr[i])

            sortedTupple = sorted(mDict.items(),key=lambda x: x[1])
            cutTupple = sortedTupple[0:p-1]
            
            for item in cutTupple:
                if intArr[item[0]] not in ansArr and len(ansArr)<=p:
                    ansArr.append(intArr[item[0]])              
                if item[0]+1<len(intArr) and intArr[item[0]+1] not in ansArr and len(ansArr)<=p:                  
                    ansArr.append(intArr[item[0]+1])                
            ansArr.sort()            
            maxim = ansArr[-1]
            answer = 0
            for x in ansArr:
                answer = answer + (maxim - x)        
            print("Case #" + str(k)+ ": " + str(answer))            
