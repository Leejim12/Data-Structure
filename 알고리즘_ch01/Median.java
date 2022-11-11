package 알고리즘_ch01;

import java.util.Scanner;

public class Median {
	static int med3(int a, int b, int c) {
		if(a>=b)
			if(b>=c)
				return b;
			else if (a <= c)
				return a;
			else
				return c;
		else if (a>c)
			return a;
		else if (b>c)
			return c;
		else
			return b;
	}
	

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("Solve the median value in 3EA Numbers.");
		
		System.out.print("The value of A : "); int a = stdIn.nextInt();
		System.out.print("The value of B : "); int b = stdIn.nextInt();
		System.out.print("The value of C : "); int c = stdIn.nextInt();
			
		System.out.println("Median Value : " + med3(a,b,c));
	}
}
