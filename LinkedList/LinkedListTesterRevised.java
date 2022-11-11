package LinkedList;

import java.util.Scanner;
import java.util.Comparator;

public class LinkedListTesterRevised {
	static Scanner stdIn = new Scanner(System.in);

	public static class Data {
		static final int NO = 1; 																							// 번호 (상수)
		static final int NAME = 2; 																							// 이름 (얘도 상수)

		Integer no; 																								// 회원번호	
		String name; 																								// 이름

		// --- 문자열 표현을 반환 ---//
		public String toString() {
			return "(" + no + ") " + name;
		}

		// --- 데이터를 읽어 들임 ---//
		void scanData(String guide, int sw) {																				// guide : 스캔,삭제,조회 등																
			System.out.println(guide + "할 데이터를 입력하세요.");

			if ((sw & NO) == NO) {
				System.out.print("번호: ");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름: ");
				name = stdIn.next();
			}
		}

		// --- 회원번호 comparator ---//
		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

		private static class NoOrderComparator implements Comparator<Data> {
			public int compare(Data d1, Data d2) {
				return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
			}
		}

		// --- 이름 comparator ---//
		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

		private static class NameOrderComparator implements Comparator<Data> {
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name);
			}
		}
	}

	// --- 메뉴 열거형 ---//
	enum Menu {
		ADD("삽입"), DELETE("삭제"), SEARCH_NO("번호 검색"), SEARCH_NAME("이름 검색"), SHOW("전체 명부 출력"), TERMINATE("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

//선형리스트 클래스 LinkedList<E>의 사용 예

//--- 데이터(회원번호＋이름) ---//

//--- 메뉴 선택 ---//
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		// 자바 객체 배열을 만들어 linked list에 insert한다.
		Menu menu; // 메뉴
		Data data; // 추가용 데이터 참조
		Data ptr; // 검색용 데이터 참조
		Data temp = new Data(); // 읽어 들일 데이터

		LinkedListRevised<Data> list = new LinkedListRevised<Data>(); // 리스트를 생성

		do {
			switch (menu = SelectMenu()) {

			case ADD: 																				// 삽입
				data = new Data();
				data.scanData("삽입", Data.NO | Data.NAME);											// scanData("삽입",Data.NO), scanData("삽입",Data.NAME) 둘 다 수행
				// 여기다가 삽입하는 메소드 넣어주면 됨.
				list.add(data, data.NO_ORDER);
				break;

			case DELETE: // 삭제
				data = new Data();
				data.scanData("삭제", Data.NO | Data.NAME);
				// 여기다가 삭제하는 메소드 넣어주면 됨.
				break;

			case SEARCH_NO: // 회원 번호 검색
				temp.scanData("검색", Data.NO);
				ptr = list.search(temp, Data.NO_ORDER);
				if (ptr == null)
					System.out.println("그 번호의 데이터가 없습니다.");
				else
					System.out.println("검색 성공: " + ptr);
				break;

			case SEARCH_NAME: // 이름 검색
				temp.scanData("검색", Data.NAME);
				ptr = list.search(temp, Data.NAME_ORDER);
				if (ptr == null)
					System.out.println("그 이름의 데이터가 없습니다.");
				else
					System.out.println("검색 성공: " + ptr);
				break;

			case SHOW: // 전체 노드를 리스트 순서대로 표시
				list.show();
				break;


			}
		} while (menu != Menu.TERMINATE);
	}
}

