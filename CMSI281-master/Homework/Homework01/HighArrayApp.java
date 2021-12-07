

public class HighArrayApp{


  public static void main(String[] args){

    int maxSize = 100; // array size
    HighArray arr; // reference to array
    arr = new HighArray(maxSize); // create the array
    arr.insert(77); // insert 10 items
    arr.insert(99);
    arr.insert(44);
    arr.insert(55);
    arr.insert(22);
    arr.insert(88);
    arr.insert(11);
    arr.insert(00);
    arr.insert(66);
    arr.insert(33);
    arr.display(); // display items
    System.out.println("Max =" + arr.getMax());



    System.out.println("Inserting duplicate values...");
      arr.insert(100);
      arr.insert(98);
      arr.insert(22);
      arr.insert(92);
      arr.insert(100);
      arr.display(); // display items
      System.out.println("Max =" + arr.getMax());
    System.out.println("Deleting duplicates...");
      arr.noDups();
      arr.display(); // display items

    System.out.println("Inserting duplicate values...");
      arr.insert(77);
      arr.insert(77);
      arr.insert(11);
      arr.insert(77);
      arr.insert(100);
      arr.display(); // display items
      System.out.println("Max =" + arr.getMax());
    System.out.println("Deleting duplicates...");
      arr.noDups();
      arr.display(); // display items

    System.out.println("Inserting duplicate values...");
      arr.insert(98);
      arr.insert(98);
      arr.insert(55);
      arr.insert(92);
      arr.insert(100);
      arr.display(); // display items
      System.out.println("Max =" + arr.getMax());
    System.out.println("Deleting duplicates...");
      arr.noDups();
      arr.display(); // display items

    System.out.println("Inserting duplicate values...");
      arr.insert(88);
      arr.insert(44);
      arr.insert(88);
      arr.insert(66);
      arr.insert(200);
      arr.display(); // display items
      System.out.println("Max =" + arr.getMax());
    System.out.println("Deleting duplicates...");
      arr.noDups();
      arr.display(); // display items

    System.out.println("Inserting duplicate values...");
      arr.insert(33);
      arr.insert(11);
      arr.insert(22);
      arr.insert(92);
      arr.insert(400);
      arr.display(); // display items
      System.out.println("Max =" + arr.getMax());
    System.out.println("Deleting duplicates...");
      arr.noDups();
      arr.display(); // display items




  } // end main()

} // end class HighArrayApp
