package MergeSort_Submit;

public class MergeSort {

//	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
//	static void merge(int[] a, int lefta, int righta, int leftb, int rightb ) {
//
//	}

	// --- 병합 정렬 ---//
	static int[] MergeSort(int[] a, int left, int right) {
		int[] tmp = new int[a.length];
	if(left<right) {
		int x = (left + right)/2;
		MergeSort(a,left,x);MergeSort(a,x+1,right);
		
		int p = left; int q = x +1; int index = p;
		
        while (p<=x || q<=right) {
            if (q>right || (p<=x && a[p]<a[q])) {
                tmp[index++] = a[p++];
            } else {
                tmp[index++] = a[q++];
            }
        }

        for (int i=left;i<=right;i++) {
            a[i]=tmp[i];
        	}
		}
	return tmp;
	}

	public static void main(String[] args) {
		int nx = 20;
		int[] x = new int[20];
		System.out.print("[정렬 전]");
		
		for (int ix = 0; ix < 20; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 50);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		x = MergeSort(x, 0, nx - 1); // 배열 x를 MergeSort

		System.out.println("[ Merge Sort 실행.] * Sorted by ASC");
		System.out.println();
		System.out.print("[정렬 후]");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}

}
