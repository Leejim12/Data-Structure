package QueenPra;

public class Back_Queen{

	public static void SolveQueen(int [][] d) {
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j<8;j++) {
				if (CheckMove(d,i,j)) {
					d[i][j]=1;
				}
			}
		}

		
//		int count = 0;
//		int ix = 0, iy = 0;

//		Point p = new Point(ix,iy);
//		d[ix][iy] = 1;
//		st.push(p);
//
//		while (count < 8) {
//			p = st.pop();
//			int cx = p.getX(); int cy = p.getY();
//			count--;
//			while (cx < d.length)
//			{
//				while (cy < d[0].length) {
//					if (CheckMove(d,cx,cy)) {
//						Point px = new Point(cx,cy);
//						st.push(px); count++;
//						break;
//					}
//					cy++;
//				}
//				cx++;
//				System.out.println("cx = "+ cx);
//				count++;
//			}
//			System.out.println("cx = "+cx + "cy = "+cy);
//			count++;
//		
//		}
//		System.out.println(count);
//		System.out.println();
	}
    //퀸 위치 출력
	public static void printt(int [][] arr) {
        for (int i = 0; i < 8; i++) {
        	for(int j = 0;j<8;j++) {
	            System.out.print(arr[i][j] + " ");
        	}
	        System.out.println();
        }
    }
	
	// 초기화 메서드
	public static void Reset(int [][] t) {
		for (int i = 0; i <8; i++)
			for (int j = 0; j < 8; j++) {
				t[i][j] = 0;	
			}
	}
	
	
//	   public static boolean check(int[][] d, int row, int col){ 
//		        int i,j; 
//		  
//		         // 같은 col에 이미 퀸이 있는지 체크 
//		         for(i = 0; i < 8; i++){ 
//		                 if(col >= 8) { 
//		                         return false; 
//		                 } 
//		             if(data[i][col] == 1){ 
//		                 return false; 
//		             } 
//		         } 
//		         // 왼쪽 대각선으로 퀸이 있는지 체크 
//		         for(i = row, j = col; i >= 0 && j >= 0; i--, j--){ 
//		             if(data[i][j] == 1){ 
//		                 return false; 
//		             } 
//		         } 
//		         // 오른쪽 대각선으로 퀸이 있는지 체크 
//		         for(i = row, j = col; i >= 0  && j <= 7; i--, j++){ 
//		             if(data[i][j] == 1){ 
//		                 return false; 
//		             } 
//		         } 
//		         return true; 
//		     }
	
	
	//// boolean들 ////////////////////////////////////////
	public static boolean checkRow(int [][] d, int row, int col) {
		for(int i = 0;i<8;i++) {
			if(d[row][i]!=0)return false; 
		}
		return true;
	}
	public static boolean checkCol(int [][] d, int row, int col) {
		for(int i = 0;i<8;i++) {
			if(d[i][col]!=0)return false; 
		}
		return true;
	}
	
	public static boolean checkDiagSW(int [][] d, int row, int col) {
		for(int i = row, j = col;i>0&&j>0;i--,j--) {
			if(d[i][j]!=0)return false;
		}
		return true;
	}
	
	public static boolean checkDiagSE(int [][] d, int row, int col) {
		for(int i = row, j = col;i>0&&j<8;i--,j++) {
			if(d[i][j]!=0)return false;
		}
		return true;
	}
	
	public static boolean CheckMove(int [][] d,int row, int col) {
		boolean a = false;
		if((checkRow(d,row,col))&&(checkCol(d,row,col))&&(checkDiagSW(d,row,col)==true)&&checkDiagSE(d,row,col)==true) {
			a=true;
		}
		return a;
	}
	
	public static void put(int [][] d, int x, int y) {
		d[x][y]=1;
	}

	
		
	
	
public static void main(String[] args) {
	int cnt = 0;
	int tempQueen[][] = new int[8][8];
	TempStack t = new TempStack(8);
	Answer a1 = new Answer(0,0,0,0,0,0,0,0);
	AnswerStack a = new AnswerStack(200);
	int pra[][] = new int[8][8];
	pra[0][0] = 1;
	System.out.println("검증"+ CheckMove(pra,1,1));
	
	
// < for문으로 잘못함 >
//	for(int i =0;i<8;i++) {
//		for(int j=0;j<8;j++) {
//			if(CheckMove(tempQueen,i,j)) {
//				put(tempQueen,i,j);
//				t.push(j);
//			}else {
//				continue;
//			}
//		}
//		if(checkRow(tempQueen,7)==false) {
//			cnt++;
//			a1.setNum8(t.pop());
//			a1.setNum7(t.pop());
//			a1.setNum6(t.pop());
//			a1.setNum5(t.pop());
//			a1.setNum4(t.pop());
//			a1.setNum3(t.pop());
//			a1.setNum2(t.pop());
//			a1.setNum1(t.pop());
//			a.push(a1);
//			System.out.println("성공");
//		}
////		Reset(tempQueen);
//	} // 상황종료

	int i = 0,j=0;
	int Dcnt = 0;
////// *
while(Dcnt < 8) {
	if(CheckMove(tempQueen,i,j)==true) {
		put(tempQueen,i,j);
		t.push(j);
		i++;
		Dcnt++;
	}
	else {
		j++;
	}
	
	if(Dcnt == 8) {
	a1.setNum8(t.pop());
	a1.setNum7(t.pop());
	a1.setNum6(t.pop());
	a1.setNum5(t.pop());
	a1.setNum4(t.pop());
	a1.setNum3(t.pop());
	a1.setNum2(t.pop());
	a1.setNum1(t.pop());
	a.push(a1);
	}
}

	
	
	
	
	
	

	//????
	//	for(int i = 0; i<8;i++) {
//		int j=0;
//		while(CheckMove(tempQueen,i,j)) {
//			put(tempQueen,i,j);
//			t.push(j);j++;
//		}
//		if(checkRow(tempQueen,7)!=true) {
//			cnt++;
//			a1.setNum8(t.pop());
//			a1.setNum7(t.pop());
//			a1.setNum6(t.pop());
//			a1.setNum5(t.pop());
//			a1.setNum4(t.pop());
//			a1.setNum3(t.pop());
//			a1.setNum2(t.pop());
//			a1.setNum1(t.pop());
//			a.push(a1);
//			System.out.println("성공");
//		}else {
//			
//		}
//	}
	
	
	System.out.println("a크기" + a.size());
	for(int z= 0; z<a.size();z++)System.out.println(a.pop().toString());
	}
}

//* 문제 해결형 자바 코딩 실습이 필요
//- main()의 작성 방법 훈련 - 
//  main() {
//	int [][]data;
// 	배열 초기화
//	SolveQueen(data);
//	배열열 출력: 8개의 queen 배치(여러가지 해를 구해 보여주기)
//  }
//- 함수 호출로 구현 훈련
//    void SolveQueen(int [][]d) {
//       //코딩 완성하기 
//    }
//  => 8  Queen 문제 풀기: 스택 사용하여 backtracking 코딩 실습
//    -> 2차원 배열에 0으로 초기화, Queen을 배치하면 1로 설정, 8 X 8 배열에 8개 퀸이 가로 세로 대각선에 충돌이 없으면 성공
//
//    -> stack에 Point 객체를 생성하여 push, pop::(x, y, move) => move는 다음 이동 가능 candidate의 column임
//        class MyStack {
// 	int top;
//	Point [] data
//	void Push(Point p);
//	Point Pop();
//         }
//         void NextMove(int[] move, int row); // current row에 대한 다음 배치 가능한 모든 column을 조사하고 move[]에 1로 설정
//         boolean CheckMove(int currentRow, int row, int col) //currentRow에 대하여 queen을 (x,y)에 배치 가능하면 true
//
//        => backtracking을 stack을 이용하여 push/pop으로 해결하는 것을 보이는 것임
//
//    -> 가로, 세로, 대각선에 대한 충돌 체크 함수 코딩
//     boolean CheckMove(x,y) {
//	checkRow(x);
//	checkCol(y);
//	checkDiagSW(x,y); //x++, y-- or x--, y++ where 0<= x,y <= 7
//	checkDiagSE(x,y); //x++, y++ or x--, y--
//     }