public class HashTable{

  private int[] array;
  private int arraySize;

    public HashTable(int size){
      array = new int[size];
      arraySize = size;
    }

    public int hashFunc(String key) {
       int hashVal = 0;
       for(int j=0; j<key.length(); j++){
          int letter = key.charAt(j) - 96;
          hashVal = (hashVal * 26 + letter) % arraySize;
      }
      return hashVal;
    } // end hashFunc3()

    public int hashFold(int d){
       int hashVal = 0;
       int interval = String.valueOf(arraySize).length() - 1;
       int digits = String.valueOf(d).length();
       String digcopy = String.valueOf(d);
       for(int i = 0; i < digits; i+=interval){
         if (digits < i + interval){
           interval = (digits - i);
         }
         hashVal += Integer.parseInt(digcopy.substring(i, i + interval));
       }

       return hashVal % arraySize;

    }

    public static void main(String [] args){
      HashTable hash = new HashTable(100);
      HashTable ha1 = new HashTable(100);
      HashTable ha2 = new HashTable(1000);
      HashTable ha3 = new HashTable(10000);
      HashTable ha4 = new HashTable(100000);

      hash.array[hash.hashFunc("mary") - 1] = hash.hashFunc("mary");
      hash.array[hash.hashFunc("lucy") - 1] = hash.hashFunc("lucy");
      hash.array[hash.hashFunc("toby") - 1] = hash.hashFunc("toby");
      hash.array[hash.hashFunc("fran") - 1] = hash.hashFunc("fran");
      hash.array[hash.hashFunc("tony") - 1] = hash.hashFunc("tony");

      System.out.println(hash.array[hash.hashFunc("mary") - 1]);
      System.out.println(hash.array[hash.hashFunc("lucy") - 1]);
      System.out.println(hash.array[hash.hashFunc("toby") - 1]);
      System.out.println(hash.array[hash.hashFunc("fran") - 1]);
      System.out.println(hash.array[hash.hashFunc("tony") - 1]);

      ha1.hashFold(123456789);
      System.out.println(ha1.hashFold(123456789));
      ha2.hashFold(123456789);
      System.out.println(ha2.hashFold(123456789));
      ha3.hashFold(123456789);
      System.out.println(ha3.hashFold(123456789));
      ha4.hashFold(123456789);
      System.out.println(ha4.hashFold(123456789));
    }
}
