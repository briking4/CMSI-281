public class BubbleSortApp
{
public static void main(String[] args){
  int maxSize = 100;
  BubbleSort arr;
  arr = new BubbleSort(maxSize);
  arr.insert(77);
  arr.insert(99);
  arr.insert(44);
  arr.insert(55);
  arr.insert(22);
  arr.insert(88);
  arr.insert(11);
  arr.insert(00);
  arr.insert(66);
  arr.insert(33);
  arr.display();
  arr.oddEvenSort();
  // array size
  // reference to array // create the array
  // insert 10 items
  // display items
  // bubble sort them
  arr.display(); // display them again
  } // end main()
  } // end class BubbleSortApp
