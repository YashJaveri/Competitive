q = input()
inp_arr = q.split("|")
terminators = []
recursor = inp_arr[0][0]
var_dash = recursor + "1"

#Find terminators
for e in inp_arr:
    if recursor not in e:
        terminators.append(e )

#Calculate rhs1
rhs1 = ""
for t in terminators:
    rhs1 += t + var_dash + "|"

#Remove |
rhs1 = rhs1[:-1]

#Calculate rhs2
rhs2 = ""
for c in inp_arr:
    if c == terminators[0]:
        rhs2 += "ep"
        break
    else:
        rhs2 += c[1:] + var_dash +"|"

print(inp_arr[0][0] + "-->" + rhs1)
print(var_dash + "-->" + rhs2)