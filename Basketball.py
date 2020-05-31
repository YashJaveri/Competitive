import math

class Solution:
    def modInverse(self, a, m):
        g = self.gcd(a, m)
        
        p = self.power(a, m - 2, m)
        
        return p
    # @param A : integer
    # @return an integer
    def power(self, x, y, m):
        if(y ==0):
            return 1
        
        p = self.power(x, y//2, m) % m
        p = (p*p) % m
        
        if(y%2 == 0):
            return p
        else:
            return ((x*p) % m)
    
    def gcd(self, a, b):
        if(a == 0):
            return b
        else:
            return self.gcd(b%a, a)
    
    
    def solve(self, A):
        if(A == 2):
            A = 3
        q = 3 * (3**(A - 2))
        p = 3 * ((3**(A - 3)) - ((3**(A - 3))/3))
        #q = q + p 
        
        if q%p == 0:
            print("q: " + str(q))
            print("p: " + str(p))
            return self.modInverse(q/p, (10**9)+7)
        else:
            x = q%p
            print("q: " + str(q))
            print("p: " + str(p))
            print(x)
            print(q//x)
            print(p//x)
            return self.modInverse((q/x)*(p/x), (10**9)+7)
#https://www.interviewbit.com/test/b1d9dc30a7/?signature=BAhpAwgsCA%3D%3D--3f52f3e83a02d4a97ed6da667a55bee349c7b7b4#/problem_6