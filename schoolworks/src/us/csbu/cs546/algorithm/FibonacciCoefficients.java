package us.csbu.cs546.algorithm;

import java.util.Scanner;

// import java.util.Scanner;

public class FibonacciCoefficients {
	
	private int[] cache;
	
	public static void main(String string[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number of Rows : ");
        int rows = scan.nextInt();
        scan.close();
		comp1(rows);
		System.out.println();
		comp2(rows);
	}
	
	public static int fibonacci(int input) {
		if (input <= 1) {
			return input;
		}
		return fibonacci(input-1) + fibonacci(input - 2);
    }

	public static void comp1(int rows) {
		int i, space, k=1;
        for(i=1; i<=rows; i++) {
            for(space=1; space<=(rows-i); space++) {
                System.out.print("  ");
            }
            while(k != ( 2*i )) {
                System.out.print(fibonacci(k) + " ");
                k++;
            }
            k = 1;
            System.out.println();
        }
	}
	
	public int fib2(int input) {
		if (input <= 1) {
			this.cache[input] = input;
			return input;
		}
		this.cache[input] = this.cache[input-1] + this.cache[input-2];
		return this.cache[input];
	}
	
	public static void comp2(int rows) {
		int i, space, k=1;
        for(i=1; i<=rows; i++) {
            for(space=1; space<=(rows-i); space++) {
                System.out.print("  ");
            }
            while(k != ( 2*i )) {
                System.out.print(fibonacci(k) + " ");
                k++;
            }
            k = 1;
            System.out.println();
        }
	}
}
