package 알고리즘_ch01;

import java.util.Scanner;

public class TwoDigits {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no;
		
		System.out.println("Input Two digit : ");
		
		do {
			System.out.println("value of NO : ");
			no = stdIn.nextInt();
			} while (no < 10 || no > 99);
		System.out.println("Value of NO : " + no);	
	}
}
