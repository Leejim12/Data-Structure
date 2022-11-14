package LinkedList;

import java.util.Comparator;

import LinkedList.LinkedListTesterRevised.Data;

public class LinkedListRevised<Data> {									// Linked List (E data, Node<E> next)
	class Node<Data> {
		private Data data; 											// 데이터
		private Node<Data> next; 										// 뒤쪽 포인터(다음 노드에 대한 참조)

// 1. Node 생성자 ---//
		Node(Data data) {                              				// Node(E data) 생성자.
			this.data = data;
			this.next = null;
		}
	}
	private LinkedListRevised<Data>.Node<Data> head; 											// head는 기본적으로 가지고 있음.

// --- 생성자(constructor) ---//
	public LinkedListRevised() {
     head = null;
	}

// (그냥 연습용) 
//	-1.연결 리스트 비어있는지 판단.
// → head = null
// 	-2.노드가 1개
// → head.next ==null
//  -3.노드가 2개
// → head.next.next == null
//  -4.꼬리노드인지 판단
// → p.next == null
	
	
	
//메소드0. Data를 가져와야함! --> 얘를 obj로 만들꺼임.
//	public Data getData(Data a) {										// a라는 데이터를 받을 경우, 
//		Node<Data> tmp = new Node(a);
//		
//	}  ----> 그냥 이거 만들지 말자(애초에 E를 Data로 바꿔주고 해봅시당.)
	
	
	
//메소드1. 노드 검색 ---//
//	public Data search(E obj, Comparator<? super E> c) {			//<? super E>는 wild card로서 E의 subclass에 대하여 모두 적용
//		Node<E> ptr = head; // 현재 스캔 중인 노드
//
//		while (ptr != null) {										// ptr(from head, to null)까지 검색 할 것임.
//			if (c.compare(obj, ptr.data) == 0) { // 검색 성공			// comparator c => [obj] , [ptr.data] 비교. 
//				return ptr.data;									// 성공 시 ptr.data 리턴
//			}
//			ptr = ptr.next; 										// IF 빠져나오면 next Nide로 이동.							
//		}
//		return null; 												// null : 데이터 없습니당.
//	} ==> 이것도 일단은 그냥 Data클래스 버전으로 해보자

// 메소드1. 노드 검색(Data클래스 버전)
	public Data search(Data obj, Comparator<? super Data> c) {		//<? super E>는 wild card로서 E의 subclass에 대하여 모두 적용
		Node<Data> ptr = head; // 현재 스캔 중인 노드

		while (ptr != null) {										// ptr(from head, to null)까지 검색 할 것임.
			if (c.compare(obj, ptr.data) == 0) { 					// (검색성공) comparator c => [obj] , [ptr.data] 비교. 
				// c.compare(1,2) -> -1
				// c.compare(2,1) ->  1
				// c.compare(1,1) ->  0
				return ptr.data;									// 성공 시 ptr.data 리턴
			}
			ptr = ptr.next; 										// IF 빠져나오면 next Node로 이동.							
		}
		return null; 												// null : 데이터 없습니당.
	}
	

//메소드2. 노드 삽입 // : 노드 삽입 시, 자동으로 정렬이 되게().
	public void add(Data obj,Comparator<? super Data> c) {		
	// ▼ 기본 
		Node<Data> OB = new Node<Data>(obj); 	
		if(this.head == null) {
			this.head = OB;} 										// 경우1. Head 비어있을때.
		else if(head.next == null) { 								// 경우2. 노드 1개일때
			if(c.compare(obj, head.data)==1) {
				head.next = OB;
			}else {Node<Data> temp = this.head; this.head = OB; OB.next = temp;}
		}

	// ▼(1) 도전 ▼///////////////////////////////////////////////////	/////////////////////
		else {														// 경우3. 이외의 경우들
			Node<Data> ptr = this.head;
			while(c.compare(obj, ptr.next.data)==-1) {
				ptr = ptr.next;
				if(ptr.next == null) {
					ptr.next = OB;
					break;
				}
			}
				if(ptr.next == null)ptr.next = OB;
				else {
				Node<Data> temp = ptr.next; // temp 생성 ///// ptr → OB → temp
				OB.next = temp;					 // OB → temp
				ptr.next = OB;					 // ptr → OB
				}
		}
	}
	
//	public void add(Data obj,Comparator<? super Data> c) {		
//	// ▼ 기본 
//		Node<Data> OB = new Node<Data>(obj); 	
//		if(this.head == null) {
//			this.head = OB; return;} 					// 경우1. Head 비어있을때.
//		Node<Data> ptr = head, q = head;				// while 돌기 위한 준비
//		while (ptr != null) {							// ptr이 null 이 아니
//			if (c.compare(obj, ptr.data) <= 0 ) {
//				Node<Data> temp = new Node<Data>(obj);
//				temp.next = ptr;
//				{
//					if (q == head) head = temp;
//					else q.next = temp;
//				}
//			}
//			else {
//				q = ptr; ptr = ptr.next;
//			}
//		}
	
	
	
//메소드3. 노드p 삭제 ---//
	public void delete(Data obj, Comparator<? super Data> c ) {//전달 객체를 삭제

		
	}

//메소드4. 전체 노드 표시 ---//
	public void show() {
		Node<Data> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;

		}
	}
}
