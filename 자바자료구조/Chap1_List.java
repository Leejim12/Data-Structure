package 자바자료구조;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Chap1_List {

	public static List<String> Merge(List<String> list1, List<String> list2) {
	    ArrayList<String> list3 = new ArrayList<String>();
		
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();		     
		
        var v1 = iter1.hasNext() ? (String)iter1.next() : null;
        var v2 = iter2.hasNext() ? (String)iter2.next() : null;

 
        while(iter1.hasNext() && iter2.hasNext()) {
        	if (v1.compareTo(v2)<0) {
        		list3.add(v1);
        		v1 = iter1.hasNext() ? iter1.next() : null;
        	}
        	else if (v1.compareTo(v2)==0){
        		list3.add(v2);
        		v1 = iter1.hasNext() ? iter1.next() : null;
        		v2 = iter2.hasNext() ? iter2.next() : null;
        	}
        	else {
        		list3.add(v2);
        		v2 = iter2.hasNext() ? iter2.next() : null;
        	}
        }
        while(v1 != null) {
        	list3.add(v1);
        	v1 = iter1.hasNext() ? iter1.next() : null;
        }
        while(v2 != null) {
        	list3.add(v2);
        	v2 = iter2.hasNext() ? iter2.next() : null;
        }      return list3;
	}
	
	
	public static void main(String[] args) {
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("서울");
				list1.add("북경");
				list1.add("상해");
				list1.add("서울");
				list1.add("도쿄");
				list1.add("뉴욕");

				ArrayList<String> list2 = new ArrayList<String>();
				list2.add("런던");
				list2.add("로마");
				list2.add("방콕");
				list2.add("북경");
				list2.add("도쿄");
				list2.add("서울");
				list2.add(1, "LA");
				
				//
				System.out.println("collection.sort()::");
			    Collections.sort(list1);
			    System.out.println("list1::");
			    for ( String city: list1)
			    	System.out.print(city+ " ");
			    System.out.println();
			    System.out.println("list2::");
			    Collections.sort(list2);
			    for ( String city: list2)
			    	System.out.print(city+ " ");

			    
///////////////////////////// 병합 메소드 /////////////////////////////////////////			    
			    ArrayList<String> list3 = new ArrayList<String>();
			
				Iterator<String> iter1 = list1.iterator();
				Iterator<String> iter2 = list2.iterator();		     
				
		        var v1 = iter1.hasNext() ? (String)iter1.next() : null;
		        var v2 = iter2.hasNext() ? (String)iter2.next() : null;

		        
//		        while(v1 != null & v2 != null){
//		        	if (v1.compareTo(v2)<0) {
//		        		list3.add(v1);		
//		                v1 = iter1.hasNext() ? iter1.next() : null;
//		        	}
//		        	else {
//		        		list3.add(v2);
//		                v2 = iter2.hasNext() ? iter2.next() : null;
//		        	}
//		        }
		        while(iter1.hasNext() && iter2.hasNext()) {
		        	if (v1.compareTo(v2)<0) {
		        		list3.add(v1);
		        		v1 = iter1.hasNext() ? iter1.next() : null;
		        	}
		        	else {
		        		list3.add(v2);
		        		v2 = iter2.hasNext() ? iter2.next() : null;
		        	}
		        }
		        while(v1 != null) {
		        	list3.add(v1);
		        	v1 = iter1.hasNext() ? iter1.next() : null;
		        }
		        while(v2 != null) {
		        	list3.add(v2);
		        	v2 = iter2.hasNext() ? iter2.next() : null;
		        }
		        	//////
//		            
//		        	while (v1 != null) {
//		                list3.add(v1);
//		                v1 = iter1.hasNext() ? iter1.next() : null;
//		            }
//		            while (v2 != null) {
//		                list3.add(v2);
//		                v2 = iter2.hasNext() ? iter2.next() : null;
//		            }
		            System.out.println(" return 병합 메소드 : " + list3);
//////////////////////////////////////////////////////////////////////////////////				
				    ArrayList<String> list4 = new ArrayList<String>();
		            list4 = (ArrayList<String>) Merge(list1,list2);
		            System.out.println("list4 : " + list4);
		            
		            
		            
		            
		            
//		        while(iter2.hasNext()){
//		        String obj = (String)iter2.next() + " ";
//	            System.out.print(obj);
//	            list3.add(obj);
//		        }
//				
//				Collections.sort(list3);
//				System.out.println();
//			    System.out.println("merge:: ");
//			    for ( String city: list3)
//			    	System.out.print(city+ " ");
			}	
}
