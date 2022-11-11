package 알고리즘_ch01;

import java.util.Scanner;

public class JudgeSign {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int n = stdIn.nextInt();
		
		if(n>0)
			System.out.println("이 수는 양수에요.");
		else if (n<0)
			System.out.println("이 수는 음수에요.");
		else
			System.out.println("이 수는 0입니다.");
	}
}
