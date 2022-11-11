package 알고리즘_ch02;

import java.util.Scanner;

public class MaxOfArray {
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i=1;i<a.length;i++) {
			if(a[i]>max)
				max=a[i];
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("The maximum value within the height");
		
		System.out.println("The amount of the people : ");
		int num = stdIn.nextInt();
		
		int[] height = new int[num];
		
		for(int i = 0;i<num;i++) {
			System.out.print("height[" + i + "]:");
			height[i] = stdIn.nextInt();
		}
		
		
		System.out.println("The maximum height value within the people : " + maxOf(height));
	}

}
