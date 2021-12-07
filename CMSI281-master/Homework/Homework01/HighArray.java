public class HighArray {

private long[] a; // ref to array a
private int nElems; // number of data items
//-----------------------------------------------------------
  public HighArray(int max){ // constructor

    a = new long[max]; // create the array
    nElems = 0; // no items yet
  }
//-----------------------------------------------------------
  public boolean find(long searchKey){
   // find specified value
    int j;
    for(j=0; j<nElems; j++){
      if(a[j] == searchKey){
        break; // exit loop before end
      } // found item?
    } // for each element,

    if(j == nElems){ // gone to end?
      return false; // yes, can’t find it
    }else{
      return true; // no, found it
    }
  }
//-----------------------------------------------------------
  public void insert(long value) {// put element into array

    a[nElems] = value; // insert it
    nElems++; // increment size
  }
//-----------------------------------------------------------
  public boolean delete(long value){

    int j;
    for(j=0; j<nElems; j++) { // look for it
      if( value == a[j] ){
        break;
      }
    }

    if(j==nElems){
      return false; // can’t find it
    }else{ // found it
      for(int k=j; k<nElems; k++){ // move higher ones down
        a[k] = a[k+1];
        nElems--; // decrement size
      }
      return true;
    }
  }
//-----------------------------------------------------------
  public void display(){ // displays array contents

    for(int j=0; j<nElems; j++){ // for each element,
      System.out.print(a[j] + " "); // display it
      System.out.println(" ");
    }
  }
//-----------------------------------------------------------
  public long getMax(){
    
    if (nElems != 0 ){
      long max= 0;

      for(int j= 0; j < nElems; j++){
        if( a[j] > max ){
          max = a[j];
        }
      }
      return max;
    }

    return -1;
}
//-----------------------------------------------------------



public void deleteAtIndex( int index ) {
   for( int i = index; i < nElems - 1; i++ ) {
      a[i] = a[i+1];
   }
   nElems--;
}

public void noDups(){

  if (nElems != 0 ){

    for(int j = 0; j < nElems; j++){

      for(int k = j + 1; k < nElems + 1; k++){
        if(a[j] == a[k]){
          deleteAtIndex(k);
        }
      }

    }
  }
}

//-----------------------------------------------------------
} // end class HighArray
