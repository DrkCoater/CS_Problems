package us.csbu.cs546.algorithm;

public class HashTable {
	private int[] hashTable = {0, 1, 2, 3, 4, 5, 6};
	
	int hashFunction(int input) {
		int idx = input % 7;
		return this.hashTable[idx];
	}
	
	int search(int input) {
		for (int i=0; i<this.hashTable.length; i++) {
			if (this.hashTable[i] == input) {
				return i;
			}
		}
		return -1;
	}
	
	void store(int index, int value) throws RuntimeException {
		if (index > 6) {
			throw new RuntimeException("Hash table index out of bound");
		}
		this.hashTable[index] = value;
	}
}
