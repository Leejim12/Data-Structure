package 자바자료구조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
public class Chap1_ArrayString{
    public static String[] removeElement1(String[] arr, String item) {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.remove(item);
        return list.toArray(String[]::new);
    }
	public static void main(String[] args) {
		

/////////////////// Practice for exchanging 'a' with 'b'///////////////////////
//		String a = "Hello", b = "good";
//		String tmp = a;
//		a = b;
//		b = tmp;
//		System.out.println(a);
//		System.out.println(b);
////////////////////////////////////////////////////////////////////////////////		
		
		
		// list 배열 
		ArrayList<String> list = new ArrayList<String>();
		// 1
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		// 2
		list.add("런던");
		list.add("로마");
		list.add("방콕");
		list.add("북경");
		list.add("도쿄");
		list.add("서울");
		// 3
		list.add(1, "LA");
		System.out.println(list.toString());
		
		
		
		// sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩
		System.out.println("collection.sort()::");
//	    이렇게 해도 됨 : Collections.sort(list);
		
		// city 확인
//	    for ( String city: list)
//	    	System.out.println(city);
	    
	    // 
//	    이렇게 해도 됨 : cities = list.toArray(new String[list.size()]);
	    String cities[] = new String[list.size()];
	    int size=0;
	    for(String temp : list){
	    	cities[size++] = temp;
	    }
  
        int minIndex = 0; //가장 적은 원소의 인덱스
        
        for(int i=0; i < cities.length; i++){
            for(int j=i+1 ; j < cities.length; j++){
                if(cities[minIndex].compareTo(cities[j])>0)
                    minIndex = j;
            }
            //스와프
            String tmp = cities[i];
            cities[i] = cities[minIndex];
            cities[minIndex] = tmp;
        }
        System.out.println(Arrays.toString(cities));

// 중복제거 1. 빈 ArrayList 만들어서 넣기         
        ArrayList<String> arrlist = new ArrayList<>();
        for(String item : cities) {
        	if(!arrlist.contains(item))
        		arrlist.add(item);
        }
        System.out.println(arrlist.toString());

//// 중복제거 2. for문 사용
//        ArrayList<String> forDel = new ArrayList<>(Arrays.asList(cities));
//        int count = forDel.size();
//        for(int i = 0;i<count;i++) {
////        	int count = forDel.size();
//        	int j = 0;
//        	while(j<count) {
//        		if(forDel.get(i)==forDel.get(j))
//        			forDel.remove(j);
//        			--count;
//        	}
//			j++;
//        }
//        System.out.println(forDel.toString());
        
        
        
System.out.println("");
System.out.println("-------- l1,l2 병합 및 오름차순 ----------");
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l1.add(1);	l2.add(2);
		l1.add(21);	l2.add(22);
		l1.add(31);	l2.add(32);
		l1.add(41);	l2.add(42);
		l1.add(51);	l2.add(52);
		l1.add(61);	l2.add(62);
		l1.add(71);	l2.add(72);
		l1.add(81);	l2.add(82);
		l1.add(91);	l2.add(92);
System.out.println("l1 : " + l1.toString());     
System.out.println("l2 : " + l2.toString());     
		ArrayList<Integer> l3 = new ArrayList<Integer>();
//		mergelist.
		
		
//int c = 0;
//int d = 0;
//	for(int i = c;i<l1.size();i++) {
//		for(int j = d;j<l2.size();j++) {
//		if(l1.get(i)<l2.get(j)) {
//			l3.add(i);
//		}
//		else {
//			l3.add(j);
//		}		
//	}
//}
	System.out.println(l3.toString());
        
        
        
        
        
        
        
///// 멀지 하는데 작은거 먼저!       
        
//	    System.out.println("정렬후::");
//	    for ( String city: cities)
//	    	System.out.println(city);
//	    //중복제거
//	    System.out.println("중복제거::");
//	    int m = 0, n = 1;
//
//	    ArrayList<String> lst = new ArrayList<String>(Arrays.asList(cities));
//	    for ( String city: lst)
//	    	System.out.println(city);

        
        
        
	}
}
