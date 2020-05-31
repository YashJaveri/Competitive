n= input()
inpStr= input()
inpArr = list(map(int, inpStr.split(' ')))
count = 0

for el in inpArr:
    count += (int)(el/3)

print(count)