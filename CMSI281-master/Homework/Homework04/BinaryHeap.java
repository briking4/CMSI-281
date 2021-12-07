import java.util.ArrayList;


   class HeapNode {

      private int data;

     // constructor
      public HeapNode( int key ) {
         data = key;
      }

     // get the data value
      public int getKey() {
         return data;
      }

     // set the data value
      public void setKey( int value ) {
         data = value;
      }

   }

   public class BinaryHeap {

      private ArrayList<HeapNode> uriah;
      private int size;

      BinaryHeap() {
         uriah = new ArrayList<HeapNode>();
         size = 0;
      }

     // First some low-hanging fruit; let's do the traversal helpers
     //  that do the indexing operations we'll need to use to find
     //  stuff in the heap
      public HeapNode getParent( int index ) {
         return uriah.get( (index - 1) / 2 );
      }

      public HeapNode getChild( int index, char child ) {
         int result = (index * 2) + 1;
         if( Character.toUpperCase( child ) == 'R') {   // make sure we're case insensitive!
            result++;
         }
         return uriah.get( result );
      }

     // this just prints the array values; it's left to the observer to figure out
     //  which HeapNode is which, in terms of parent and child
      public void print() {
         for( int i = 0; i < size; i++ ) {
            System.out.print( "[" + uriah.get( i ).getKey() + "]" );
         }
      }

     // Now we can handle insertions.  ArrayList has a nice "add" method
     //  that makes things easy.  We *DO* have to deal with the primitive
     //  to Object situation, but that is trivial...
      public void insert( int value ) {
         uriah.add( new HeapNode( value ) );
         bubbleUp( size );                 // WOW that was easy!
         size++;
      }

      public HeapNode remove(int value){
        HeapNode root = uriah.get(0);
        uriah.set(0,uriah.get(--size));
        trickleDown(0);
        return root;
      }

     // Here is the bubble method that does the swappy thang....
     //  Whaddya mean?!  OF COURSE it is recursive!  Fuggeddaboutit...
      public void bubbleUp( int index ) {
         if( index == 0 ) {   // base case:
            return;           //  we are already at the root, so we are done
          }

         HeapNode parent = getParent( index );
         int parentIndex = (index -1) / 2;
         if( uriah.get( parentIndex ).getKey() < uriah.get( index ).getKey() ) {
            HeapNode temp = uriah.get( index );
            uriah.set( index,  uriah.get( parentIndex ) );
            uriah.set( parentIndex, temp );
            bubbleUp( parentIndex );
         }
      }

      public void trickleDown(int index){
        HeapNode root = uriah.get(index);
        int leftIndex = getChild(index, 'L').getKey();
        int rightIndex = getChild(index, 'R').getKey();
        int largest;

        if(leftIndex <= size){

          if(leftIndex < rightIndex){
            largest = rightIndex;
          }else{
            largest = leftIndex;
          }

          if(uriah.get(largest).getKey() > root.getKey()) {
            HeapNode temp = root;
            uriah.set(index, uriah.get(largest));
            uriah.set(largest, temp);
            trickleDown(largest);
          }

        }

      }

      public static void main( String[] args ) {


      }
   }
