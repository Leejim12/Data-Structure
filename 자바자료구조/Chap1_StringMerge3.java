package 자바자료구조;

import java.util.Arrays;
public class Chap1_StringMerge3 {

	public static void main(String[] args) {
		
		

				String[] Arg1 = new String[7];
				Arg1[0] = "서울";
				Arg1[1] = "북경";
				Arg1[2] = "상해";
				Arg1[3] = "서울";
				Arg1[4] = "도쿄";
				Arg1[5] = "서울";
				Arg1[6] = "뉴욕";

				String[] Arg2 = new String[8];
				Arg2[0] = "런던";
				Arg2[1] = "로마";
				Arg2[2] = "방콕";
				Arg2[3] = "북경";
				Arg2[4] = "도쿄";
				Arg2[5] = "서울";
				Arg2[6] = "서울";
				Arg2[7] = "LA";
////// 1. 그냥 단순 병합 ( ArrayCopy 이용 ) //////////				
				int dL = Arg1.length + Arg2.length;
				
				String[] res1 = new String[dL];
				
				System.arraycopy(Arg1, 0, res1, 0, Arg1.length);
				System.arraycopy(Arg2, 0, res1, Arg1.length, Arg2.length);
				
				System.out.println(Arrays.toString(res1));
				
			
///// 2. 반복문 이용.
				String[] res2 = new String[dL];
				int i = 0; int j = 0; int k = 0;
			    while(i<Arg1.length && j < Arg2.length) {
			    	if(Arg1[i].compareTo(Arg2[j])<0) {
			    		res2[k]=Arg1[i];
			    		i++;
			    		k++;
			    	}
			    	else if(Arg1[i].compareTo(Arg2[j])==0) {
			    		res2[k]=Arg1[i];
			    		i++;
			    		j++;
			    		k++;
			    	}
			    	else {
			    		res2[k]=Arg2[j];
			    		j++;
			    		k++;
			    	}
		    }
			    System.out.println(Arrays.toString(res2));



			}	
}