package LinkedList;
import LinkedList.LinkedListTesterRevised.Data;
public class Pra {

	public static void main(String[] args) {
		
		LinkedListRevised A = new LinkedListRevised();
		Data vir = new Data();
		
		
		Data tmp1 = new Data();
		tmp1.no = 1;
		tmp1.name = "민수";
		Data tmp2 = new Data();
		tmp2.no = 3;
		tmp2.name = "영희";
		Data tmp3 = new Data();
		tmp3.no = 2;
		tmp3.name = "철수";
		Data tmp4 = new Data();
		tmp4.no = 0;
		tmp4.name = "찬희";
		
		A.add(tmp1, tmp1.NO_ORDER);
		A.add(tmp2, tmp2.NO_ORDER);
		A.add(tmp3, tmp3.NO_ORDER);
		A.add(tmp4, tmp4.NO_ORDER);
		A.show();
		System.out.println(tmp1.NO_ORDER.compare(tmp2, tmp1));
	}

	

	
	
}
