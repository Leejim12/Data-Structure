package 알고리즘_ch04;

import java.util.Scanner;

public class IntStackTester {
	public static void main(String[] args) {
		Scanner StdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while (true) {
			System.out.println();
			System.out.printf("현재 데이터 갯수 : %d / %d \n", s.size(), s.getCapacity());
			System.out.println("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료 : ");
			
			int menu = StdIn.nextInt();
			if(menu == 0) break;
			
			int x;
			switch(menu) {
				case 1: // push
					System.out.println("데이터 : ");
					x = StdIn.nextInt();
					try {
						s.push(x);
					} catch(IntStack.OverflowStackException e) {
						System.out.println("꽉 찼습니다.");
					}
					break;
					
				case 2 : // 팝
					try {
						x = s.pop();
						System.out.println("Pop data : " + x);
					} catch(IntStack.EmptyIntStackException e) {
						System.out.println("Empty Stack");
					}
					break;
					
				case 3 : //피크
					try {
						x = s.peek();
						System.out.println("Peek data : " + x);
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("Empty Stack");
					}
				case 4 : // 덤프
					s.dump();
					break;
			}
		}
	}

}
