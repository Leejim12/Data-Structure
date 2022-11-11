package Quick_Sort;
// 비 재귀적 구현 ( 교재 232p ) // 비 재귀적 구현 // 배열2개 사용
import java.util.Scanner;

public class Quick_Sort2 {

	// [메소드1] a 배열에서 idx1 요소와 idx2 요소 바꿈.
	 static void swap(int[] a, int idx1, int idx2) {
		 int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	 }
 
	// [메소드2] a 배열에서 left idx부터 right idx까지 quick sort.
	// 퀵정렬(비재귀버전)
	 static void quickSort2(int[] a, int left, int right) {
	     IntStack lstack = new IntStack(right - left + 1);    //나눌 범위의 왼쪽 끝 요소의 인덱스를 저장하는 스택
	     IntStack rstack = new IntStack(right - left + 1);    //나눌 범위의 오른쪽 끝 요소의 인덱스를 저장하는 스택
	     
	     lstack.push(left);
	     rstack.push(right);
	     
	     while (lstack.isEmpty() != true) {
	         //정렬할 배열의 범위
	         int pl = left  = lstack.pop();        //왼쪽 커서
	         int pr = right = rstack.pop();        //오른쪽 커서
	         int x = a[(left + right) / 2];        //피벗
	         
	         
	         //피벗을 기준으로 하위 그룹과 상위 그룹으로 나눈다
	         do {
	             while (a[pl] < x) pl++;
	             while (a[pr] > x) pr--;
	             
	             if (pl <= pr)
	                 swap(a, pl++, pr--);
	         } while (pl <= pr);
	         
	         if (left < pr) {
	            lstack.push(left);      //하위 그룹 범위의
	             rstack.push(pr);        //인덱스를 푸시
	         }
	         if (pl < right) {
	             lstack.push(pl);        //상위 그룹 범위의
	            rstack.push(right);     //인덱스를 푸시
	         }
	     }
	 }

	 
	 
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in); // 배열 크기 정하기 위한 Scanner

		System.out.println("Quick sort");
		System.out.println("요소 수 : ");
		int nx = stdIn.nextInt();
		int[] arr = new int[nx];
		
		for(int i = 0; i < nx;i++) {
			System.out.println();
//			System.out.println("값을 넣으세요 : " + i+1 );
			arr[i] = stdIn.nextInt();
		}
		
		quickSort2(arr,0,nx-1);
		
		System.out.println("ASC Sort");
		for (int i = 0; i < nx;i++)
			System.out.println("arr[" + i + "]=" + arr[i]);
	}

}
