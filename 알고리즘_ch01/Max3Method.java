package 알고리즘_ch01;

public class Max3Method {
	// return the maximun value in 3EA numbers
	static int max3(int a, int b, int c) {
		int max = a;
		if (b > max)
			max = b;
		if (c > max)
			max = c;
		return max;
	}
	
	
	public static void main(String[] args) {
		System.out.println("max3(1232341,12323,1121232) : " + max3(1232341,12323,1121232));
	}

}
