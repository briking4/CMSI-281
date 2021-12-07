// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp ////////////////////////////////////////////////////////////////
public class BubbleSort {

  private long[] a; // ref to array a private
  int nElems; // number of data items
//--------------------------------------------------------------
  public BubbleSort(int max) {
    a = new long[max];
    nElems = 0;
  }
// constructor
// create the array // no items yet
//--------------------------------------------------------------
  public void insert(long value) {
    a[nElems] = value;
    nElems++;
  }
// put element into array
// insert it
// increment size
//--------------------------------------------------------------
  public void display() { // displays array contents
    for(int j=0; j<nElems; j++){ // for each element,
    System.out.println(a[j] + " "); // display it
    }
  }
//--------------------------------------------------------------
  public void oddEvenSort(){
    int valuesSwap = 1;
    while(valuesSwap != 0){
    valuesSwap = 0;
    for (int o = 1; o < nElems - 2; o+=2){
      if(a[o] > a[o+1]){
        swap(o,o+1);
        valuesSwap++;
      }
    }
    for (int e = 0; e < nElems; e +=2){
      if(a[e] > a[e+1]){
        swap(e,e+1);
        valuesSwap++;
      }
    }
    }
// outer loop (backward) // inner loop (forward) // out of order?
// swap them
 } // end bubbleSort() //--------------------------------------------------------------
   private void swap(int one, int two) {
    long temp = a[one];
    a[one] = a[two];
    a[two] = temp;
   }
 }

//-------------------------------------------------------------- } // end class ArrayBub
