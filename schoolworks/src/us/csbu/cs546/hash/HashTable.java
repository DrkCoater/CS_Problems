package us.csbu.cs546.hash;
/**
 * A hash table that assumes no case of collision.
 *
 */
public class HashTable {
    private final static int TABLE_SIZE = 7;

    HashEntry[] table;

    HashTable() {
          table = new HashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

    public int get(int key) {
          int hash = (key % TABLE_SIZE);
         
          if (table[hash] == null)
                return -Integer.MAX_VALUE;
          else
                return table[hash].getValue();
    }

    public void put(int key, int value) {
          int hash = (key % TABLE_SIZE);
          
          table[hash] = new HashEntry(key, value);
    }
    public static void main(String []args){
    
    	HashTable hashTable = new HashTable();
    	hashTable.put(2, 9);
    	hashTable.put(17, 10);
    	hashTable.put(11, 609);
    	hashTable.put(26, 19);
    	hashTable.put(6, 30);
    	for (int i = 0; i<7; i++){
    		System.out.println(hashTable.get(i));
    	}
    	
    }
    
}
