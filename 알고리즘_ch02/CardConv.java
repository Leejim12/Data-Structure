package 알고리즘_ch02;

import java.util.Scanner;

public class CardConv {
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x%r);
			x/=r;
		}while (x!=0);
	
	for (int i = 0; i < digits/2;i++) {
		char t = d[i];
		d[i] = d[digits - i - 1];
		d[digits - i -1] = t;
	}
	return digits;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no;
		int cd;
		int dno;
		int retry;
		char[] cno = new char[32];
		
		System.out.println("10진수 기수 변환");
		do {
			do {
				System.out.println("변환하고자 하는 수 :");
				no = stdIn.nextInt();
			}while(no<0);
			
			do {
				System.out.println("어떤 진수로 변환할래? (2~36) : ");
				cd = stdIn.nextInt();
			}while (cd<2 || cd>36);
		
			dno = cardConv(no,cd,cno);
			
			System.out.print(cd + " 진수로");
			for(int i = 0; i<dno;i++) 
				System.out.print(cno[i]);
			System.out.println("입니다!");
			
			System.out.print("Again?(1...Y/0...N):");
			retry = stdIn.nextInt();
			} while(retry ==1);
		System.out.println("이용해주셔서 감사합니다!");
	
	}

}
