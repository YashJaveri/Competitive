map = {

}

def findSet():

	n = int(raw_input()) 

	for i in range(n) :
		string = input()  #string

		a = string.split(' ')[0]
		b = int(string.split(' ')[1])  #bool	
		
		if a in map.keys():
			map[a][b] = map[a][b] + 1

		else :
			if b == 0:
				map[a]=[1,0]

			else:
				map[a] = [0,1]

					

	count = 0
	for string,val in map.items():
		count += max(val[0],val[1])

	print(count)




T = int(raw_input()) #test cases

for t in range(T):
	findSet()