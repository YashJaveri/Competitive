from decimal import Decimal

def gcd(a,b):
	if b==0:
		return a
	else:
		return gcd(b,a%b)

p = int(input('Enter the value of p = '))
q = int(input('Enter the value of q = '))
no = int(input('Enter the value of text = '))
n = p*q
t = (p-1)*(q-1)
for e in range(2,t):
	if gcd(e,t)== 1:
		break
for i in range(1,10):
	x = 1 + i*t
	if x % e == 0:
		d = int(x/e)
		break
    
cypher_text_temp = Decimal(0)
cypher_text_temp =pow(no,e)
cypher_text = cypher_text_temp % n
decrypted_temp = Decimal(0)
decrypted_temp = pow(cypher_text,d)
decrypted = decrypted_temp % n
print('n = '+str(n)+' e = '+str(e)+' t = '+str(t)+' d = '+str(d)+' cipher_text = '+str(cypher_text)+' decrypted_text = '+str(decrypted))
