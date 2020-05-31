public class SortedList
{
  public static CNode insertSortedList(CNode start, int n)
  {
    CNode newNode = new CNode();
    CNode temp = new CNode();
    newNode.value = n;
    
    if(start == null){
        newNode.next = newNode;
        //start = newNode;
    }
    else if(start.value >= n){
        temp = start;
        while(temp.next != start)
            temp = temp.next;
            
        temp.next = newNode;
        newNode.next = start;
        //start = newNode;
    }
    else{
        temp = start;
        while(temp.next != start && temp.next.value < newNode.value){
           temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    return newNode;
  }
}