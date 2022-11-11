package 알고리즘_ch02;
import java.util.Arrays;
import java.util.Scanner;


public class ReverseArray {
	
	static void swap(int[] a,int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}
	
	static void reverse(int[] a) {
		for(int i = 0;i<a.length/2;i++)
			swap(a,i,a.length-i-1);
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("total index number : ");
		int num = stdIn.nextInt();
		
		int[] x = new int[num];
		
		for(int i = 0;i<num;i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.println("x = " + Arrays.toString(x));
		
		reverse(x);
		
		System.out.println("Reverse arrangement.");
		System.out.println("x = " + Arrays.toString(x));
		
	}

}
