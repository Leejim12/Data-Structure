package LinkedList;
import LinkedList.LinkedListTesterRevised.Data;
public class Pra {

   public static void main(String[] args) {
      
      LinkedListRevised A = new LinkedListRevised();
      Data vir = new Data();
      
      
      Data tmp1 = new Data();
      tmp1.no = 3;
      tmp1.name = "민수";
      Data tmp2 = new Data();
      tmp2.no = 1;
      tmp2.name = "영희";
      Data tmp3 = new Data();
      tmp3.no = 2;
      tmp3.name = "철수";
      Data tmp5 = new Data();
      tmp5.no = 0;
      tmp5.name = "뭄";
      Data tmp4 = new Data();
      tmp4.no = 4;
      tmp4.name = "찬희";
      A.add(tmp1, tmp1.NO_ORDER); // 경우1. Null 인 경우 add (O)
      A.show();
      System.out.println();
      A.add(tmp2, tmp2.NO_ORDER); // 1개 있을때 (O)
      A.show();
      System.out.println();
      A.add(tmp3, tmp3.NO_ORDER); // 
      A.show();
      System.out.println();
      A.add(tmp4, tmp4.NO_ORDER);
      A.show();
      System.out.println();
      A.add(tmp5, tmp5.NO_ORDER);
      A.delete(tmp4, tmp4.NO_ORDER);
      A.show();
      System.out.println();      
      A.delete(tmp3, tmp3.NO_ORDER);
      A.show();
   }
   

   

   
   
}