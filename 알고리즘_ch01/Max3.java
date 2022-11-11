package 알고리즘_ch01;

import java.util.Scanner;

public class Max3 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("--- The maximun values in 3EA Numbers ---");
		System.out.println("Value of 'A' : "); int a = stdIn.nextInt();
		System.out.println("Value of 'B' : "); int b = stdIn.nextInt();
		System.out.println("Value of 'C' : "); int c = stdIn.nextInt();
		
		int max = a;
		if (b > max) max = b;
		if (c > max) max = c;
		
		System.out.println("************ The maximum value is : " + max);
	}

}
