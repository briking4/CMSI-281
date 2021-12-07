/*
 *  File name: QueueApp.java
 *  Purpose: tests the implementation of a Queue using an array
 *  @author:  Dr. Johnson
 *  @date:  2018-09-17
 *  @version: 1.0.0
 */

class QueueApp {
   public static void main(String[] args) {

      Queue theQueue = new Queue( 15 );   // queue holds 5 items
      System.out.println( "Empty queue initialized: " );
      theQueue.displayQueue();

      theQueue.insert(10);                // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);
      System.out.println( "After four insertions: " );
      theQueue.displayQueue();

      theQueue.remove();                  // remove 3 items
      theQueue.remove();                  // (10, 20, 30)
      theQueue.remove();
      System.out.println( "After three removals: " );
      theQueue.displayQueue();

      theQueue.insert(50);                // insert 4 more items
      theQueue.insert(60);                // (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);
      System.out.println( "After four new insertions: " );
      theQueue.displayQueue();

      theQueue.insert(101);
      theQueue.insert(102);
      theQueue.insert(103);
      theQueue.insert(104);
      theQueue.insert(105);
      theQueue.insert(106);
      theQueue.insert(107);
      theQueue.insert(108);
      theQueue.insert(109);
      theQueue.insert(110);
      System.out.println( "After ten new insertions: " );
      theQueue.displayQueue();

      System.out.println( "Attempting to insert two more items: " );
      theQueue.insert(111);
      theQueue.insert(112);
      System.out.println( "After two failed attempts: " );
      theQueue.displayQueue();

      System.out.println( "Removed: " + theQueue.remove() );
      theQueue.displayQueue();

     // remove and displayQueue
      System.out.println( "Emptying queue, showing removed items in order: " );
      while( !theQueue.isEmpty() ) {
         long n = theQueue.remove();
         System.out.print(n);
         System.out.print(" ");
      }
      System.out.println("");

      System.out.println( "\nShowing empty queue: " );
      theQueue.displayQueue();

   }
}
