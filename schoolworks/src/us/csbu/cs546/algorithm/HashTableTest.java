package us.csbu.cs546.algorithm;

public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable sample = new HashTable();
		int defaultStoreValue_1 = sample.hashFunction(14);
		int defaultStoreValue_2 = sample.hashFunction(15);
		int defaultStoreValue_3 = sample.hashFunction(16);
		int defaultStoreValue_4 = sample.hashFunction(17);
		int defaultStoreValue_5 = sample.hashFunction(18);
		int defaultStoreValue_6 = sample.hashFunction(19);
		int defaultStoreValue_7 = sample.hashFunction(20);
		System.out.printf("Default value for 14 is %s \n", defaultStoreValue_1);
		System.out.printf("Default value for 15 is %s \n", defaultStoreValue_2);
		System.out.printf("Default value for 16 is %s \n", defaultStoreValue_3);
		System.out.printf("Default value for 17 is %s \n", defaultStoreValue_4);
		System.out.printf("Default value for 18 is %s \n", defaultStoreValue_5);
		System.out.printf("Default value for 19 is %s \n", defaultStoreValue_6);
		System.out.printf("Default value for 20 is %s \n", defaultStoreValue_7);
		sample.store(0, 12);
		sample.store(1, 19);
		sample.store(2, -2);
		sample.store(3, 30);
		sample.store(4, -100);
		sample.store(5, 49);
		sample.store(6, 40);
		int value_1 = sample.hashFunction(14);
		int value_2 = sample.hashFunction(15);
		int value_3 = sample.hashFunction(16);
		int value_4 = sample.hashFunction(17);
		int value_5 = sample.hashFunction(18);
		int value_6 = sample.hashFunction(19);
		int value_7 = sample.hashFunction(20);
		System.out.printf("Default value for 14 is %s \n", value_1);
		System.out.printf("Default value for 15 is %s \n", value_2);
		System.out.printf("Default value for 16 is %s \n", value_3);
		System.out.printf("Default value for 17 is %s \n", value_4);
		System.out.printf("Default value for 18 is %s \n", value_5);
		System.out.printf("Default value for 19 is %s \n", value_6);
		System.out.printf("Default value for 20 is %s \n", value_7);
		
		// try to store using an out of bound index.
		try {
			sample.store(29, 123);
		} catch (Exception e) {
			System.out.println(e);
		}
		int searchResult = sample.search(49);
		System.out.printf("Index of 49 is %s \n", searchResult);
		searchResult = sample.search(412);
		System.out.printf("Seach of not existed value 412 is %s \n", searchResult);
	}
	
}
