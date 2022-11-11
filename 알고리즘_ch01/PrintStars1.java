package 알고리즘_ch01;

import java.util.Scanner;

public class PrintStars1 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n,w;
		
		System.out.println("print n the amount of wEA. *note : have to change the rows each of the w EA");
	
	
	do {
		System.out.print(" n : ");
		n = stdIn.nextInt();
	} while(n<=0);
	
	do {
	System.out.print("w value : ");
	w=stdIn.nextInt();	
	} while(w<=0||w>n);
	
	for (int i = 0;i<n;i++) {
		System.out.print("*");
		if(i%w==w-1)
			System.out.println();
	}
	if (n%w!=0)
		System.out.println();
	// 마지막 줄바꿈을 하기 위한
	
	
	}
}
