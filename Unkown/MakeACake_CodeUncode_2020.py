length = input()
str_arr = input().split(" ")
sort_arr= [int(i) for i in str_arr]
arr = sort_arr.copy()
printNewLine_flag = True

sort_arr.sort()
stack = []
mem = []

for j in sort_arr:
    stack.append(j)
    #print(j)

for j in arr:    
    if len(stack) != 0:
        #print("j: " + str(j) + " top: " + str(stack[-1]))
        if j < stack[-1]:
            mem.append(j)
            #print("j: " + str(j) + ", mem: " + str(mem))
            print()
        else:
            stack.pop()
            print(j, end="")
            if len(mem) != 0 and len(stack) != 0:
                mem.sort()
                while len(mem) != 0 and mem[-1]>=stack[-1]:
                    print(" " + str(mem.pop()), end="")
                    stack.pop()
                    printNewLine_flag = True
            if printNewLine_flag:
                print()
                printNewLine_flag = False
while len(stack) != 0:
    print(stack.pop())