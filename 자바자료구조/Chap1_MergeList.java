package 자바자료구조;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class Chap1_MergeList {
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
				ArrayList<String> list3 = new ArrayList<String>();
				ArrayList<String> listres = new ArrayList<String>();
				
				Iterator<String> iter1 = list1.iterator();
				Iterator<String> iter2 = list2.iterator();
				
			//구현 부분	
				while(iter1.hasNext())
				{
					list3.add(iter1.next());
				}
				while(iter2.hasNext())
				{
					list3.add(iter2.next());
				}
				
				for(int i=0;i<list3.size();i++) {
					for(int j=i+1;j<list3.size();j++) {
						if(list3.get(i)==list3.get(j))
							list3.remove(i);
					}
				}
				
				

				System.out.println();
			    System.out.println("merge:: ");
			    for ( String city: list3)
			    	System.out.print(city+ " ");
			    
			}	
}
