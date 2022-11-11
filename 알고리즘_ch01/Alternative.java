package 알고리즘_ch01;

import java.util.Scanner;

public class Alternative {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		
		System.out.println("Print + and - in turns.");
		
		System.out.println("n : ");
		n = stdIn.nextInt();
		
		for(int i = 0; i < n; i ++){
			if (i%2 == 0)
				System.out.print("+");
			else
				System.out.print("-");
		}
	}

}
