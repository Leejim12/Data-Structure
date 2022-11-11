package Quick_Sort;

import java.util.Scanner;

public class Quick_Sort_Basic {
	//
	 static void swap(int[] a, int idx1, int idx2) { // a : 배열, idx1 : 요소1, idx2 : 요소2
		 int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	 }
 
	 static void quickSortB(int[] a, int left, int right) {
		 int pl = left;
		 int pr = right;
		 int x = a[(pl+pr)/2]; //얘가 피벗(가운데 요소)
		 
		 do {
			 while(a[pl]<x) pl++;
			 while(a[pr]>x) pr--;
			 if(pl<=pr)
				 swap(a,pl++,pr--);
		 }while(pl<=pr);
	 if(left<pr) quickSortB(a,left,pr);
	 if(pl<right) quickSortB(a,pl,right);
	 }
	 
	 
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in); // 배열 크기 정하기 위한 Scanner

		System.out.println("Quick sort");
		System.out.println("amount of index");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		// 입력받아서 x배열에 요소들 input
		for(int i = 0; i < nx;i++) {
			System.out.println();
			x[i] = stdIn.nextInt();
		}
		
		quickSortB(x,0,nx-1);
		
		System.out.println("ASC Sort");
		for (int i = 0; i < nx;i++)
			System.out.println("x[" + i + "]=" + x[i]);
		
	}

}
