package Quick_Sort;


// int형 고정 길이 스택
public class IntStack {
	private int[] stk; // 스택용 배열
	private int capacity;	// 스택 용량
	private int ptr;	// 스택 포인터
	
	/////////////////////////////////에러, 메소드 정의 ///////////////////////////////
	// 실행 예외 : 빈 스택
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	// 실행 예외 : 꽉 참
	public class OverflowStackException extends RuntimeException{
		public OverflowStackException(){}
	}
	
	// 생성자
	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		}	catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public int push(int x) throws OverflowStackException{
		if (ptr >= capacity)
			throw new OverflowStackException();
		return stk[ptr++] = x;
	}
	
	
	public int pop() throws EmptyIntStackException{
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	public int peek() throws EmptyIntStackException{
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr -1];
	} // 꼭대기 데이터 들여다보기

	public void clear() {
		ptr = 0;
	}
	
	public int indexOf(int x) {
		for (int i = ptr-1; i>=0; i--)
			if(stk[i] == x)
				return i;
		return -1; // 검색 실패
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	public boolean isFull() {
		return ptr >= capacity;
	}
	

	public void dump() {
		if(ptr <=0)
			System.out.println("빈 스택.");
		else {
			for(int i = 0;i<ptr;i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
