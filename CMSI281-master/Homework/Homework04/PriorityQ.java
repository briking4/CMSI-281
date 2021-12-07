// priorityQ.java
// demonstrates priority queue

class PriorityQ{
// array in sorted order, from max at 0 to min at size-1 private
int maxSize;
private int nItems;
BinaryHeap heap;
//-------------------------------------------------------------
//-------------------------------------------------------------

  public PriorityQ(int s) {
    maxSize = s;
    heap = new BinaryHeap();
    nItems = 0;
  }

  public void insert(int item) {
    heap.insert(item);
    nItems++;
  }

  public HeapNode remove(){ // remove max item
    nItems--;
    return ( heap.remove(peekMax()) );
  }

  public int peekMax(){
    return heap.getParent(0).getKey();
  } // peek at max item

  public boolean isEmpty(){ // true if queue is empty
   return (nItems==0);
  }
  //-------------------------------------------------------------
  public boolean isFull(){ // true if queue is full
   return (nItems == maxSize);
  } //-------------------------------------------------------------

  public void print(){

  }

  public static void main(String[] args) {
    PriorityQ thePQ = new PriorityQ(5);

    thePQ.insert(30);
    thePQ.insert(50);
    thePQ.insert(10);
    thePQ.insert(40);
    thePQ.insert(20);

    while( !thePQ.isEmpty() ) {
      int item = thePQ.remove().getKey();
      System.out.print(item + ""); //   // end while
      System.out.println("");
    }

  } // end main() //-------------------------------------------------------------
} // end class PriorityQ
