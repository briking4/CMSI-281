import java.util.Scanner;
import java.lang.Thread;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Simon{

  private String sequence;
  private String temp;


  public String randomColor(){
    int color = (int)(Math.random() * 4);
    if (color == 0){
      return "G";
    }
    else if(color == 1){
      return "R";
    }
    else if(color == 2){
      return "B";
    }
    else{
      return "Y";
    }
  }
  public void add(){
    temp = randomColor();
    sequence = sequence + temp;
  }
  public static void main(String [] args) {
    Simon simon = new Simon();
    Scanner sb = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = 0;
    boolean keepPlaying = true;
    boolean t = true;
    System.out.print("Hello! Do you want to play Simon? (Y/N)");
    if(sb.nextLine().equalsIgnoreCase("Y")){
      while(keepPlaying){
      t = true;
      count = 0;
      simon.sequence = "";
      while(t){
      simon.add();
      System.out.print(simon.temp);
      try{
        Thread.sleep(1000);
      }
      catch (InterruptedException e){
        System.out.print(e);

      }
      System.out.print("\b");
      System.out.print("Enter the sequence {R, G, B, Y}");

      try{
        if(!(br.readLine().equalsIgnoreCase(simon.sequence))){
           t = false;
        }
        else{
          count++;
          System.out.print("\b");
        }
      }
      catch (IOException e){
        System.out.print(e);

      }
      System.out.print("\b");

      }
      System.out.println("Awwwwgh, You Lost. Thanks for playing. Your score was: " + count);
      System.out.print("Want to play again? (Y/N)");
      if(sb.nextLine().equalsIgnoreCase("N")){
        keepPlaying = false;
      }

    }
  }
    else{
      System.out.println("Maybe next time...");
    }
  }
}
