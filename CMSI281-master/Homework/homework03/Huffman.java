import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman{
  HuffNode root;
  String[] huffCode;
  PriorityQueue<HuffNode> queue;
  String encodedMessage;
  String decodedMessage;



  public Huffman(){
    root = null;
    huffCode = new String[30];
    queue = null;
    encodedMessage = "";
    decodedMessage = "";

  }

// method to get frequency of characters
  public int[] getFrequency( String s){

    String string = s.toUpperCase();

    int[] freq = new int[string.length()];

    for (int i=0; i<freq.length; i++){
      freq[i]= 1;
    }

    char charArray[] = string.toCharArray();

    for (int i = 0; i < string.length(); i++){;
      for(int j = i + 1; j < string.length(); j++){
        if (charArray[i] == charArray[j]){
          freq[i]++;
          freq[j] = 0;
        }
      }
    }
    return freq;

  }

// method to create PriorityQueue

  public PriorityQueue<HuffNode> createQueue(int[] freqArray, char[] charArray){
    PriorityQueue<HuffNode> pQueue = new PriorityQueue<HuffNode>();

    for (int i = 0; i < charArray.length; i++){
      if(freqArray[i] == 0){
        continue;
      }

      HuffNode node = new HuffNode(charArray[i]);
      node.freq = freqArray[i];
      pQueue.add(node);
    }

    queue = pQueue;

    return pQueue;

  }

// method to create Huffman Tree

  public HuffNode createTree( PriorityQueue<HuffNode> queue ) {

    HuffNode root = null;

		while (queue.size() > 1) {

			HuffNode left = queue.peek();
			queue.poll();

			HuffNode right = queue.peek();
		  queue.poll();

      HuffNode sumNode = new HuffNode('*');

      sumNode.add(left,"L");
      sumNode.add(right,"R");

			sumNode.freq = left.freq + right.freq;

      root = sumNode;

			queue.add(root);

		}

		return root;
	}

// method to traverse tree and assigning codes

  public void preOrderPrinter(HuffNode node, String code) {

      if( node ==  null) {
        return;
      }

      System.out.println( "[" + node.data + "," + node.freq + "]" );

      preOrderPrinter(node.getChild("L"), code + "0");

      preOrderPrinter(node.getChild("R"), code + "1");


      if(node.getChild("L") == null && node.getChild("R") == null){
        System.out.println("LEAF FOUND: [" + node.data + ", code: " + code + "]" );

        if (node.data < 65){
          if (node.data == 46){
            huffCode[27] = code;
          }
          if (node.data == 10){
            huffCode[28] = code;
          }
          if (node.data == 44){
            huffCode[29] = code;
          }

        }else{
          huffCode[node.data - 65] = code;
        }

      }

  }

// method to encode message by searching through array of each characters code

  public String encode(char[] charArray) {
    String encodedM = "";
    int charIndex = 0;

    for(int i = 0; i < charArray.length; i++){
      if (charArray[i] < 65){
        if (charArray[i] == 46){
          charIndex = 27;
        }
        if (charArray[i] == 10){
          charIndex = 28;
        }
        if (charArray[i] == 44){
          charIndex = 29;
        }

      }else{
        charIndex = charArray[i] - 65;
      }
      String code = huffCode[charIndex];
      encodedM += code;
    }
    return encodedM;
  }

  // method to dencode the encoded message by moving left and right in tree until character is found

  public String decode(String encode, HuffNode root) {
    StringBuilder sb = new StringBuilder();
    String decodedM = "";

    HuffNode currentNode = root;

    for (int i = 0; i < encode.length(); i++){
      if (encode.charAt(i) == '0'){
        currentNode = currentNode.getChild("L");
      }else if (encode.charAt(i) == '1'){
        currentNode = currentNode.getChild("R");
      }

      if(currentNode.getChild("L") == null && currentNode.getChild("R") == null){
        System.out.println("LEAF FOUND D: [" + currentNode.data + "]" );
        sb.append(currentNode.data);
        currentNode = root;
      }

    }
    decodedM = sb.toString();
    return decodedM;
  }


  public static void main(String args[]) {
    Huffman h = new Huffman();

// scanning user input
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter String:");
    String string = scan.nextLine();
    string = string.toUpperCase();

// creating character array and their frequency
    char[] charArray = string.toCharArray();

    int[] freqArray = h.getFrequency(string);

// creating PriorityQueue and creating huffman tree

    PriorityQueue<HuffNode> queue = h.createQueue(freqArray,charArray);
    HuffNode root = h.createTree(queue);

// Pre-order traversing tree

    System.out.println(" \n Traversing Tree (Pre-Order):");

    h.preOrderPrinter(root,"");

// Encoding and Decoding Message

    h.encodedMessage = h.encode(charArray);
    System.out.println(" \n HuffMan Message - Encoded: " + h.encodedMessage + "\n");

    System.out.println("DECODING MESSAGE:");

    h.decodedMessage = h.decode(h.encodedMessage, root);
    System.out.println(" \n HuffMan Message - Decoded: " + h.decodedMessage + "\n");

  }

//HuffNode Class

  public class HuffNode implements Comparable<HuffNode> {
     @Override

     public int compareTo(HuffNode h){

      if(this.freq != h.freq){
        return this.freq - h.freq;
      }else{
        return this.data - h.data;
      }
    }

     char data;
     HuffNode left;
     HuffNode right;
     int freq;

     HuffNode( char d ) {
        data = Character.toUpperCase(d);
        freq = 0;
        left = null;
        right = null;
     }

// method to add left and right children to node
     public void add(HuffNode h, String child){
       child = child.toUpperCase();
       if (child.equals("L")){
         left = h;
       }else if(child.equals("R")){
         right = h;
       }else{
         throw new IllegalArgumentException();
       }
     }

// method to get left and right children of node

     public HuffNode getChild(String child){
       child = child.toUpperCase();
       if(child.equals("L") || child.equals("R")){
         return (child.equals("L") ? left : right);
       } else{
         throw new IllegalArgumentException();
       }
     }

  }

}
