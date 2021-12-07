
public class CircLinkedList {

      public Node head;
      public Node tail;
      public int  size;
      public Node currentNode;

     // the constructor
      public CircLinkedList() {
         head = null;
         tail = null;
         size = 0;
         currentNode = head;

      }

      public int getSize() {
         return size;
      }

      public void prepend( int dataToAdd ) {
         Node newNode = new Node( dataToAdd );
         if (head == null){
           head = newNode;
         }
         newNode.next = head.next;
         head.next = newNode;
         size++;
      }

      public void insert(int data){
        Node newNode = new Node(data);
        if (head == null){
          head = newNode;
          currentNode = head;
        }else{
          tail.next = newNode;
        }
          tail = newNode;
          tail.next = currentNode;
        size++;
      }

      public int remove(){
        int temp = currentNode.next.data;
        currentNode.next = currentNode.next.next;
        return temp;
      }

      public void step(){
        currentNode = currentNode.next;
      }



      public class Node {

         int data;            // remember this is an CircLinkedList
         Node next;           // here's the self-referential part

         // constructor
         Node( int d ) {
            data = d;
            next = null;
         }
      }

      public static void main (String[] args){
        CircLinkedList myList = new CircLinkedList();
        myList.insert( 23 );
        myList.insert( 19 );
        myList.insert( 17 );
        myList.insert( 13 );
        myList.insert( 11 );
        myList.insert(  7 );
        myList.insert(  5 );
        myList.insert(  3 );
        myList.insert(  2 );


        myList.remove();
        myList.remove();


        System.out.println( "Current Node is: " + myList.currentNode.data);    // 23
        myList.step();
        System.out.println( "Current Node is: " + myList.currentNode.data );    // 19
        myList.step();
        System.out.println( "Current Node is: " + myList.currentNode.data );    // 17
        myList.step();
        System.out.println( "Current Node is: " + myList.currentNode.data);    // 13
        myList.step();
        System.out.println( "Current Node is: " + myList.currentNode.data );    // 11
        myList.step();
        System.out.println( "Current Node is: " + myList.currentNode.data );    // 7
        myList.step();
        System.out.println( "Current Node is: " + myList.currentNode.data);    // 5
        myList.step();
        System.out.println( "Current Node is: " + myList.currentNode.data );    // 3
        myList.step();
        System.out.println( "Current Node is: " + myList.currentNode.data );    // 2

        System.out.println( "Head Node is: " + myList.head.data );    // 23
        System.out.println( "Tail Node is: " + myList.tail.data );    // 2
        System.out.println( "Tail next Node is: " + myList.tail.next.data );    // 23




      }
   }
