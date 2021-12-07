public class Josephus extends CircLinkedList{

  private int groupSize;
  private int counter;
  private CircLinkedList circle;
  private int nPeople;

   public Josephus(int g, int c){
     circle = new CircLinkedList();
     groupSize = g;
     counter = c;
     nPeople = groupSize;
   }

   public void createGroup(){
     for (int i = 1; i <= groupSize; i++){
       circle.insert(i);
     }
   }

   public void displayGroup(){
     System.out.println("List Contents:");
     for (int i = 0; i < groupSize; i++){
       System.out.println( "[" +  circle.currentNode.data + "]");
       circle.step();
     }
     System.out.println();
   }

   public void run(){

     System.out.println( "[" +  circle.currentNode.data + "]");
     circle.step();

     while(nPeople != 1){
       for (int i = 0; i < counter - 2; i++){
         System.out.println( "[" +  circle.currentNode.data + "]");
         circle.step();
       }
       System.out.println( "[" +  circle.currentNode.data + "]");
       System.out.print( circle.remove() + " dies an honorable death.");
       System.out.println();
       circle.step();
       nPeople--;
     }

     System.out.println();
     System.out.println(circle.currentNode.data + " lives another day!");

   }

   public static void main(String [] args){
     Josephus j = new Josephus(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
     j.createGroup();
     j.displayGroup();
     j.run();
   }
}
