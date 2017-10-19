package us.csbu.cs546.algorithm;

import java.util.Scanner;

public class DisplayPatterns {

	public static void main(String args[])
    {
		//print indent pattern
		printIndent();
		//print triangle
		printTriangle();
    }
	static void printIndent(){

        int i, j, k=8;
        for(i=0; i<5; i++)
        {
            for(j=0; j<k; j++)
            {
                System.out.print(" ");
            }
            k = k - 2;
            for(j=0; j<=i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
	}
	
	public static void printTriangle()
    {
        int i, space, rows, k=0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number of Rows : ");
        rows = scan.nextInt();
        for(i=1; i<=rows; i++)
        {
            for(space=1; space<=(rows-i); space++)
            {
                System.out.print("  ");
            }
            while(k != (2*i-1))
            {
                System.out.print("*");
                k++;
            }
            k = 0;
            System.out.println();
        }
        scan.close();
    }

}
