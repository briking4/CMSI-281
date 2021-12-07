package copiersupport;
import java.lang.StringBuffer;
import java.io.IOException;





public class MyFileCopier{

  public static void main( String args[]){
    SourceFile sf = new SourceFile("hello.txt");
    String content = sf.read();
    TargetFile tf = new TargetFile("hello.txt");
    tf.write(content);
  }
}
