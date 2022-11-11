package 알고리즘_ch01;

import java.util.Scanner;

public class SumFor2 {
////// 양수만 받기 위한 Do-while 사용
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		System.out.println("Sigma Calculate ");

		
		
		do {
			System.out.print("n:");
			n = stdIn.nextInt();
		}	while(n<=0);
		
		
		int sum = 0;
		for(int i = 1;i<=n;i++)
			sum+=i;
		
		System.out.println("Sigma : " + sum);
	}
	

}
