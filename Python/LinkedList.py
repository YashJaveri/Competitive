class Node:
    def __init__(self,data):
        self.data= data
        self.next= None


class LinkedList(object):
    def __init__(self):
        self.head = None

    def printList(self):
        node = self.head

        while node != None:
            print(node.data, end=" ")
            node = node.next
        print(" ")
    def insert(self, val):
        newNode = Node(val)
        newNode.next = None
        if self.head==None:
            self.head = newNode
        else:
            node = self.head
            while node.next != None:
                node = node.next
            node.next = newNode       
    def delete(self, val):
        temp = None
        prev = temp
        temp = self.head

        if temp==None:
            print("Nothing to delete!")
        elif temp == self.head:
            self.head = temp.next
            del temp
        else:            
            while temp.data != val:
                prev = temp
                temp = temp.next
            prev.next = temp.next
            temp.next = None
            del temp
                    

myList = LinkedList()
inp = 0

while inp != 4:
    _inp = input("Enter\n1.to insert\n2.to delete\n3.to print\n4.to exit\n")
    inp = int(_inp)
    if inp == 1:
        val = input("Enter the value:")
        myList.insert(int(val))
    elif inp is 2:
        val = input("Enter the value to be deleted:")
        myList.delete(int(val))
    elif inp == 3:
        myList.printList()
