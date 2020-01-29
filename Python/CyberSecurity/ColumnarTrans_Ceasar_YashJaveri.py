import math

#--------------------Ceasar Cipher--------------------
def encrypt(pt, c_key):
        plain_text = pt
        key = c_key
        ct = ""
        
        for p in plain_text:
                if(p.isdigit()):                                                        
                        asc = ord(p)+key         
                        if(asc>83):
                                ct += chr(47+asc-83)
                        elif(asc>57):
                                ct += chr(64+asc-57)    #Jump to alphabets
                        else:
                                ct += chr(asc)  #Stay in numeric's range
                else:
                        asc = ord(p)+key
                        if(asc>100):
                                ct += chr(64+asc-100)
                        elif(asc>90):
                                ct += chr(47+asc-90)    #Jump to numeric's range
                        else:
                                ct += chr(asc)  #Stay oin numeric's range
        return ct  

def decipher(ct, d_key):
        cipher_text = ct
        pt = ""
        key = d_key
        
        for c in cipher_text:
                if(c.isdigit()):
                        asc = ord(c)-key 
                        #print(c + ": " + str(asc))
                        if(asc<22):
                                pt += chr(58-(22-asc))
                        elif(asc<48):
                                pt += chr(91-(48-asc))    #Jump to alphabets
                        else:
                                pt += chr(asc)  #Stay oin numeric's range
                else:
                        asc = ord(c)-key
                        #print(c + ": " + str(asc))
                        if(asc<55):
                                pt += chr(91-(55-asc))
                        elif(asc<65):
                                pt += chr(58-(65-asc))    #Jump to numeric's range
                        else:
                                pt += chr(asc)  #Stay oin numeric's range
        return pt

#--------------------Columnar Transposition Cipher--------------------
def m_split(t):
	return [char for char in t]


def m_find_all(m_str, ch):
	ar = []
	for i in range(0, len(m_str)):
		if(ch == m_str[i]):
			ar.append(i)
	return ar


def t_encrypt(pt, key):
	rows = math.ceil(len(pt)/len(key))
	cols = len(key)
	cells = rows * len(key)
	arr = m_split(key)
	arr.sort()
	ct = ""
	i = 0
	for e in range(0, len(arr)):
		if e != 0 and arr[e] == arr[e-1]:
			i += 1
			og_pos = m_find_all(key, arr[e])[i] + 1
		else:
			i = 0
			og_pos = key.find(arr[e])+ 1
			
		x = og_pos
		while x <= cells:
			if x>len(pt):
				ct+= 'X'
			else:
				ct += pt[x-1]
			x = x + cols
	return ct


def t_decrypt(ct, key):
	rows = int(len(ct)/len(key))
	i = 0	
	groups = []

	while i<len(ct):
		s = ""
		for x in range(0,rows):
			s += ct[i]
			i+=1
		if i%rows==0:			
			groups.append(s)
			s = ""

	sorted_key_arr = m_split(key)
	sorted_key_arr.sort()
	sorted_key = ""
	sorted_key = sorted_key.join(sorted_key_arr)
	pt_order = []

	i=0
	pt = ""
	count =0

	for c in range(0, len(key)):					
		all = m_find_all(sorted_key, key[c])
		if len(all) == 1:
			pt_order.append(all[0])
		else:
			for i in range(c, -1, -1):
				if key[i] == key[c]:
					count += 1						
			pt_order.append(all[count-1])
			count = 0

	for x in range(0, rows):
		for o in pt_order:
			pt += groups[o][x]
	return pt


print(".\n.\nYASH JAVERI, 60004170124\n.\n.")
print("Choose encryption algorithm:\n1. Ceasar\n2. Columnar Transposition")
option = int(input())

if option == 1:
	print("Enter plain text and key: ")
	plain_t = input()
	key = int(input())
	cipher_t = encrypt(plain_t, key)
	print("Plain text: " + plain_t + ", Key: " + str(key) + ", Encrypted cipher text: " + cipher_t + "\n.\n.")
	plain_t = decipher(cipher_t, key)             
	print("Cipher text: " + cipher_t + ", Key: " + str(key) + ", Decrypted plain text: " + plain_t + "\n.\n.")

	print("Attacking....\n.\n.")
	for i in range(0, 26):
			plain_t = decipher(cipher_t, i)
			print("Attacking with key " + str(i) + ". Decrypted plain text: " + plain_t)
else:
	plain_t = ""
	key = ""
	print("Enter plain text and key: ")
	plain_t = input()
	key = input()

	cipher_t = t_encrypt(plain_t, key)
	print("Plain text: " + plain_t + ", Key: " + key + ", Encrypted cipher text: " + cipher_t + "\n.\n.")

	plain_t = t_decrypt(cipher_t, key)
	print("Cipher text: " + cipher_t + ", Key: " + key + ", Decrypted plain text: " + plain_t + "\n.\n.")