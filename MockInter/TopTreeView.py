'''You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
Top view means when you look the tree from the top the nodes, what you will see will be called the top view of the tree. See the example below.
You only have to complete the function.
For example :

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Top View : 1 -> 2 -> 5 -> 6

Input Format
You are given a function,

void topView(node * root) {
}
Constraints
1 Nodes in the tree  500

Output Format
Print the values on a single line separated by space.
Sample Input

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4'''


class Node:
    def __init__(self, info): 
        self.info = info  
        self.left = None  
        self.right = None 
        self.level = None 

    def __str__(self):
        return str(self.info) 

class BinarySearchTree:
    def __init__(self): 
        self.root = None

    def create(self, val):  
        if self.root == None:
            self.root = Node(val)
        else:
            current = self.root
         
            while True:
                if val < current.info:
                    if current.left:
                        current = current.left
                    else:
                        current.left = Node(val)
                        break
                elif val > current.info:
                    if current.right:
                        current = current.right
                    else:
                        current.right = Node(val)
                        break
                else:
                    break

"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.info (the value of the node)
""" 
def func(root, dist, lev, mmap): 
    if(root == None): 
        return
      
    if dist not in mmap: 
        mmap[dist] = [root.info,lev] 
    elif(mmap[dist][1] > lev): 
        mmap[dist] = [root.info,lev]

    func(root.left, dist - 1, lev + 1, mmap) #go left
    func(root.right, dist + 1, lev + 1, mmap) #go right

def topView(root): 
    mmap = {} 
      
    func(root, 0, 0, mmap) 
    for k, v in sorted (mmap.items()): 
        print(v[0], end = " ") 

tree = BinarySearchTree()
t = int(input())

arr = list(map(int, input().split()))

for i in range(t):
    tree.create(arr[i])

topView(tree.root)