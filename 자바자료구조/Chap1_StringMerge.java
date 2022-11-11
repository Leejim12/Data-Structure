package 자바자료구조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Chap1_StringMerge {
	public static String[] removeElement(String[]arr, String item) {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
		list.remove(item);
		return list.toArray(String[]::new);
	}
	
	public static String[] removeDuplicate(String[]lst) {
	    int count = lst.length;
	    for (int i = 0; i < count; i++) {
//	    	for (int j = i+1; j <count; j++)
	    	int j = i+1;
		    while(j < count) {
		    		if (lst[i].compareTo(lst[j])==0){
		    				lst = removeElement(lst,lst[j]);
		    				count--;
		    				System.out.println("j =" + j + " count = " + count);
		    		}
		    		else j++;
		    	}
	    	}
	   return lst;
	}
	
	public static void main(String[] args) {
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("서울");
				list1.add("북경");
				list1.add("상해");
				list1.add("서울");
				list1.add("도쿄");
				list1.add("서울");
				list1.add("뉴욕");

				ArrayList<String> list2 = new ArrayList<String>();
				list2.add("런던");
				list2.add("로마");
				list2.add("방콕");
				list2.add("북경");
				list2.add("도쿄");
				list2.add("서울");
				list2.add("서울");
				list2.add(1, "LA");
				
				List<String> list3 = Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList());
			    Collections.sort(list3);				
				
				
				
				//
				System.out.println("collection.sort()::");
			    Collections.sort(list1);
			    System.out.println("list1::");
			    for ( String city: list1)
			    	System.out.print(city+ " ");
			    Collections.sort(list2);

			    
			    String []lst1 = new String[0];
			    lst1 = list1.toArray(lst1);
			    String []lst2 = new String[0];
			    lst2 = list2.toArray(lst2);
			    String []lst3 = new String[0];
			    lst3 = list3.toArray(lst3);
			    
			    
			    lst1 = removeDuplicate(lst1);
			    lst2 = removeDuplicate(lst2);
			    lst3 = removeDuplicate(lst3);

			    
			    System.out.println();
			    System.out.println("list1::");
			    for ( String city: lst1)
			    	System.out.print(city+ " ");
			    System.out.println();

			    System.out.println("list2::");
			    for ( String city: lst2)
			    	System.out.print(city+ " ");
			    System.out.println();
			    
			    
			    System.out.println("List3은 Merge(lst1,lst2)");
			    System.out.println("list3::");
			    for ( String city: lst3)
			    	System.out.print(city+ " ");
			    

			    
//			    Collections.sort(list2);
//			    
//			    String []lst1 = new String[0];
//			    lst1 = list1.toArray();
//			    
//			    for ( String city: list2)
//			    	System.out.print(city+ " ");
//				ArrayList<String> list3 = new ArrayList<String>();
//				
//				Iterator<String> iter1 = list1.iterator();
//				Iterator<String> iter2 = list2.iterator();
//			//구현 부분	
//
//
//
//				System.out.println();
//			    System.out.println("merge:: ");
//			    for ( String city: list3)
//			    	System.out.print(city+ " ");
//			    
			}	
}