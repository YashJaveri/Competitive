import math 

n = int(input())
small = big = 1
primes = []
flag = True

for i in range(0, n):
    str_arr = input().split(" ")
    arr= [int(i) for i in str_arr]
    primes.append(arr[0])
    small *= int(math.pow(arr[0], arr[1]))
    big *= int(math.pow(arr[0], arr[2]))

sum = small + big
dups = [big]
for e in primes:
    if len(dups) != 0:
        for x in dups:
            if x == small*e:
                flag = False
                break
    if flag:
        dups.append(big/e) 
        #print("big: " + str(big/e) + " small: " + str(small*e))
        sum += int(big/e) + int(small*e)
        flag = True
        
print(str(sum%(int(math.pow(10, 9)) + 7)))