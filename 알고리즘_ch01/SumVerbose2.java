package 알고리즘_ch01;

import java.util.Scanner;

public class SumVerbose2 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		
		System.out.println("1~n Sigma Calculate");
		
		do {
			System.out.println("n : ");
			n = stdIn.nextInt();
		}while(n<=0 || n>=51);
		
		int sum = 0;
		
		for (int i = 1; i <= n; i ++) {
			System.out.print(i + " + ");
			sum += i;
		}
		
//		System.out.print(n + " = ");
//		sum += n;
//		System.out.print(sum);
	}

}
