package copiersupport;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class TargetFile {

  String copyFilename = "";

  public TargetFile(String filename){
    try{
      File copyFile = new File(filename + ".copy.txt");
      copyFile.createNewFile();
      copyFilename = copyFile.getName();
    } catch(IOException e){

      System.out.println("An error occured");

    }

  }

  public void write(String content){

    try{
      FileWriter writer = new FileWriter(copyFilename);
      writer.write(content);
      writer.close();
    } catch(IOException e){
      System.out.println("An error occured");
    }

  }


  public static void main (String args[]){
    // TargetFile tf = new TargetFile("hello.txt");
    // tf.write("omg hey!");

  }

}
