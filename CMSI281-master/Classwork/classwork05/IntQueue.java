public class IntQueue {

   IntLinkedList myQueue;

   IntQueue() {
      myQueue = new IntLinkedList();         // constructor
   }

   public void insert( int itemToinsert ) {
      myQueue.prepend( itemToinsert );
   }

   public int peek() {
      return myQueue.getIteratorAt( 0 ).getCurrentInt();     // we use the iterator
   }

   public int remove() {
      System.out.println("Index: " + (myQueue.getSize() - 1 ));
      //int index = 1;
      //index++;
      return myQueue.removeAt( myQueue.getSize() - 1);
   }

   public static void main( String[] args ) {
      IntQueue testQueue = new IntQueue();
      testQueue.insert( 19 );
      testQueue.insert( 23 );
      testQueue.insert( 29 );
      testQueue.insert( 31 );
      testQueue.insert( 37 );
      testQueue.insert( 41 );
      testQueue.insert( 43 );
      testQueue.insert( 47 );
      testQueue.insert( 51 );
      testQueue.insert( 57 );
      System.out.println( "Last in: " + testQueue.peek() );      // 57
      System.out.println( "Removing first in: " + testQueue.remove() );         // 57 removed
      System.out.println( "Last in: " + testQueue.peek() );      // 51
      System.out.println( "Removing first in: " + testQueue.remove() );         // 51 removed
      System.out.println( "Last in: " + testQueue.peek() );      // 47
      System.out.println( "Removing first in: " + testQueue.remove() );         // 47 removed
      System.out.println( "Last in: " + testQueue.peek() );      // 57
      System.out.println( "Removing first in: " + testQueue.remove() );         // 57 removed
      System.out.println( "Last in: " + testQueue.peek() );      // 51
      System.out.println( "Removing first in: " + testQueue.remove() );         // 51 removed
      System.out.println( "Last in: " + testQueue.peek() );      // 47
      System.out.println( "Removing first in: " + testQueue.remove() );         // 47 removed
      System.out.println( "Last in: " + testQueue.peek() );      // 43
      System.out.println( "Removing first in: " + testQueue.remove() );         // 57 removed
      System.out.println( "Last in: " + testQueue.peek() );      // 51
      System.out.println( "Removing first in: " + testQueue.remove() );         // 51 removed
      System.out.println( "Last in: " + testQueue.peek() );      // 47
      System.out.println( "Removing first in: " + testQueue.remove() );         // 47 removed
    



}
}
