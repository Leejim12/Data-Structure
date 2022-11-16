package DoublyLinkedList;

import java.util.Comparator;

import DoublyLinkedList.DoubledLinkedListTester;

public class DoubledLinkedList<E> {

//원형 이중 연결 리스트 클래스 - first node를 가짐

	// --- 노드 ---//
	class Node<E> {
		private E data; // 데이터
		private Node<E> llink; // 앞쪽포인터(앞쪽 노드에 대한 참조)
		private Node<E> rlink; // 뒤쪽포인터(뒤쪽 노드에 대한 참조)
		// --- 생성자(constructor) --- //
	}

	private Node<E> first; // 머리 포인터(참조하는 곳은 더미노드)

	// --- 생성자(constructor) --- //
	public DoubledLinkedList() {
		first = new Node<E>(); // dummy(first) 노드를 생성
	}

	// --- 리스트가 비어있는가? --- //
	public boolean isEmpty() {
		return first.rlink == first;
	}

	// --- 노드를 검색 --- //
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = first.rlink; // 현재 스캔 중인 노드

		while (ptr != first) {
			if (c.compare(obj, ptr.data) == 0) {
				return ptr.data; // 검색 성공
			}
			ptr = ptr.rlink; // 뒤쪽 노드에 주목
		}
		return null; // 검색 실패
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		if(this.isEmpty()) {
			System.out.println("노드 없음.");
		}
		if(this.first == this.first.rlink) {
			System.out.println(this.first.data);return;
		}
		
		Node<E> ptr = this.first.rlink; // 더미 노드의 뒤쪽 노드
		while (ptr != first) {
			System.out.println(ptr.data);
			ptr = ptr.rlink;
		}
	}

	public void connect(Node<E> A,Node<E> B) {
		A.rlink = B;
		B.llink = A;
	}
	
	
	// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(E obj, Comparator<? super E> c) {
		Node<E> OB = new Node<E>();
		OB.data = obj;
		Node<E> ptr = new Node<E>();
		ptr = this.first;
		if(this.first.data == null) {
			this.first = OB;
			connect(this.first,this.first);
			return;
		}
		if(c.compare(OB.data, first.data)<0) {
			this.first = OB;
			connect(OB,ptr);			
			return;
		}
		
		if(first == first.llink && this.first.data!=null) {						//1개
			connect(this.first,OB);
		}	// 1개 끝.
		
		while(ptr.rlink != this.first) {
			if(c.compare(OB.data, ptr.data)>0) { // OB가 더 커짐. ptr -> OB -> ptr.rlink
				Node<E> temp = ptr.rlink;
				connect(ptr,OB);
				connect(OB,temp);
				return;
			}else {
				ptr=ptr.rlink;continue;
			}
		}
		connect(ptr,OB);
		connect(OB,this.first);
		return;
	}

	// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	// 기본 Delete
	public void delete(E obj, Comparator<? super E> c) {
		Node<E> ptr = first.rlink;
		
		while(ptr!=first) {
			if(ptr == obj) {
				ptr.llink.rlink=ptr.rlink;
				ptr.rlink.llink=ptr.llink;
				return;
			}
			ptr=ptr.rlink;
		}
	}
}	
