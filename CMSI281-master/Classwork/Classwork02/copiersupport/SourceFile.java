package copiersupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.StringBuffer;



public class SourceFile{

  public File sourceFile;


  public SourceFile(String filename){
     sourceFile = new File(filename);
  }

  public String read(){
    StringBuffer sb = new StringBuffer();

    try{
      String line;
      FileReader fr = new FileReader(sourceFile);
      BufferedReader br = new BufferedReader(fr);

      while((line = br.readLine()) != null){
        sb.append(line);
        sb.append(System.lineSeparator());
      }

    } catch (IOException e){
      System.out.println("There was a problem reading the file");
    }

    return sb.toString();

  }

  //method for read


  public static void main (String args []){
    // SourceFile sf = new SourceFile("hello.txt");
    // System.out.println(sf.read());
  }
}
