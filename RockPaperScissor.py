n = int(input())
a = int(input())
inpStr = input()
inpStr1 = ""

inpStr1 = inpStr[:a] + 'a' + inpStr[a:]

def remove_char(input_string, index):
    first_part = input_string[:index]
    second_part = input_string[index+1:]
    return first_part + second_part

def getWin(mstr):
    if mstr == 'R':
        return 'P'
    elif mstr == 'S':
        return 'R'
    elif mstr == 'P':
        return 'S'
    else:
        #print("invalid")
        return ''

aStr = 'a'
aCount = 0

while len(inpStr1)>2:
    inpStr2 = ""
    for i in range(0, len(inpStr1), 2):    
        if i+1<len(inpStr1):
            #print(inpStr1[i])
            if inpStr1[i] == 'R' and inpStr1[i+1] == 'S':
                inpStr2 += inpStr1[i]
            elif inpStr1[i] == 'S' and inpStr1[i+1] == 'R':
                inpStr2 += inpStr1[i+1]
            elif inpStr1[i] == 'P' and inpStr1[i+1] == 'R':
                inpStr2 += inpStr1[i]
            elif inpStr1[i] == 'R' and inpStr1[i+1] == 'P':
                inpStr2 += inpStr1[i+1]
            elif inpStr1[i] == 'P' and inpStr1[i+1] == 'S':
                inpStr2 += inpStr1[i+1]
            elif inpStr1[i] == 'S' and inpStr1[i+1] == 'P':
                inpStr2 += inpStr1[i]
            elif inpStr1[i]=='a':
                if inpStr1[i+1] != aStr:
                    aCount += 1
                    aStr = getWin(inpStr1[i+1])
                inpStr2 += inpStr1[i]
            elif inpStr1[i+1]=='a':
                if inpStr1[i] != aStr:
                    aCount += 1
                    aStr = getWin(inpStr1[i])
                inpStr2 += inpStr1[i+1]
        elif i == len(inpStr1)-1:
            inpStr2 += inpStr1[i]
    inpStr1 = inpStr2

#print(inpStr2)
print(aCount)
