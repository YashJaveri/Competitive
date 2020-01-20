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
        
pt = ""
print("\nSAP ID: 60004170124\nYash Javeri\n")
print("Enter plain text: ")
pt = str(input())
print("Enter key: ")
key = int(input())

ct = encrypt(pt, key)
print("\nEncrypted: " + ct)
pt = decipher(ct, key)             
print("Decrypted: " + pt)


print(".\n.\n.\nAttacking....\n.\n.")
for i in range(0, 26):
        pt = decipher(ct, i)
        print("Attacking with key " + str(i) + ". Decrypted plain text: " + pt)

