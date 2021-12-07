public class IntStack {

      CircLinkedList myStack;

      IntStack() {
         myStack = new CircLinkedList();         // constructor
      }

      public void push( int itemToPush ) {
         myStack.prepend( itemToPush );
      }

      public int pop() {
         return myStack.remove();
      }

      public static void main(String[] args){
        IntStack myStack = new IntStack();
        myStack.push( 23 );
        myStack.push( 19 );
        myStack.push( 17 );
        myStack.push( 13 );
        myStack.push( 11 );
        myStack.push(  7 );
        myStack.push(  5 );
        myStack.push(  3 );
        myStack.push(  2 );

        myStack.pop();
        myStack.pop();

      }
}
