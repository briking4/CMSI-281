public class Deque{

  private long[] dequeArray;
  private int nItems;
  private int maxSize;

  private int rearLeft;
  private int rearRight;
  private int leftTemp;
  private int rightTemp;
  private long temp;

  public Deque(int s){
      maxSize = s;
      dequeArray = new long[maxSize];
      nItems = 0;

      rearLeft    =  maxSize - 1;
      rearRight   =  0;
      leftTemp = rearRight;
      rightTemp = rearLeft;
  }

  public void insertLeft(long j){
    if (nItems == maxSize){
      System.out.println("Deque is full");
    }
    else{
      dequeArray[rearRight++] = j;
      nItems++;
      System.out.println("Inserted " + j + " at " + (rearRight - 1));
    }
    if (rearLeft < rearRight){ //wraparound
      rearRight = 0;
      rearLeft = maxSize - 1;

    }

  }
  public void insertRight(long j){
    if (nItems == maxSize){
      System.out.println("Deque is full");
    }
    else{
      dequeArray[rearLeft--] = j;
      nItems++;
      System.out.println("Inserted " + j + " at " + (rearLeft + 1));

    }
    if (rearLeft < rearRight){ //wraparound
      rearRight = 0;
      rearLeft = maxSize - 1;
    }

  }
  public void removeLeft(){
    if (nItems == 0 ){
      System.out.println("Deque is Empty");
    }
    else{
      temp = dequeArray[leftTemp];
      dequeArray[leftTemp++] = 0;
      nItems--;
      System.out.println("Removed " + temp + " at " + (leftTemp - 1));

    }
    if (rightTemp < leftTemp){ //wraparound
      leftTemp = 0;
      rightTemp = maxSize - 1;

    }
  }
  public void removeRight(){
    if (nItems == 0 ){
      System.out.println("Deque is Empty");
    }
    else{
      temp = dequeArray[rightTemp];
      dequeArray[rightTemp--] = 0;
      nItems--;
      System.out.println("Removed " + temp + " at " + (rightTemp + 1));

    }
    if (rightTemp < leftTemp){ //wraparound
      leftTemp = 0;
      rightTemp = maxSize - 1;

    }
  }
  public boolean isEmpty(){
    if(nItems == 0){
      return true;
    }
    return false;
  }
  public boolean isFull(){
    if(nItems == maxSize){
      return true;
    }
    return false;
  }
  public void displayDeque(){
    System.out.println(" Left Index: " + rearRight);
    System.out.println("Right Index: " + rearLeft);
    for (long i : dequeArray){
      System.out.println(" [" +  i + "] ");
    }
  }
  public static void main(String [] args ){
    Deque d = new Deque(10);
    d.insertLeft(5);
    d.insertLeft(10);
    d.insertRight(15);
    d.insertLeft(20);
    d.insertRight(25);
    d.insertRight(30);
    d.insertLeft(35);
    d.insertRight(40);
    d.displayDeque();
    d.removeLeft();
    d.removeLeft();
    d.removeRight();
    d.removeLeft();
    d.removeRight();
    d.removeRight();
    d.removeLeft();
    d.removeRight();
    d.displayDeque();
    d.insertLeft(5);
    d.insertLeft(10);
    d.insertRight(15);
    d.insertLeft(20);
    d.insertRight(25);
    d.insertRight(30);
    d.insertLeft(35);
    d.insertRight(40);
    d.displayDeque();
    d.removeLeft();
    d.removeLeft();
    d.removeRight();
    d.removeLeft();
    d.removeRight();
    d.removeRight();
    d.removeLeft();
    d.removeRight();
    d.displayDeque();

  }
}
