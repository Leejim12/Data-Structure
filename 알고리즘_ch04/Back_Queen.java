package 알고리즘_ch04;

public class Back_Queen{
	public static void SolveQueen(int [][] d) {
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j<8;j++) {
				if (CheckMove(d,i,j)) {
					d[i][j]=1;
				}
			}
		}

		
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
	
	//// boolean들 ////////////////////////////////////////
	public static boolean checkRow(int [][] d, int cx) {
		if(d[cx][0] == 0 &&
				d[cx][1] == 0 &&
				d[cx][2] == 0 &&
				d[cx][3] == 0 &&
				d[cx][4] == 0 &&
				d[cx][5] == 0 &&
				d[cx][6] == 0 && 
				d[cx][7] == 0) return true;
		else return false;
	}
	public static boolean checkCol(int [][] d, int cy) {
		if(d[0][cy] == 0 &&
				d[0][cy] == 0 &&
				d[1][cy] == 0 &&
				d[2][cy] == 0 &&
				d[3][cy] == 0 &&
				d[4][cy] == 0 &&
				d[5][cy] == 0 &&
				d[6][cy] == 0 &&
				d[7][cy] == 0) return true;
		else return false;
	}
	
	public static boolean checkDiagSW(int [][] d, int cx, int cy) {
		int cnt = 0;
		boolean a = false;
		if(cx+cy==7) {
			for(int i = 0;i<8;i++) {
				if(d[i][7-i]==0)cnt++;
			}a=(cnt==8);
		}
		
		else if(cx+cy<7) {
			cnt=0;int i =0;
			while(cx+cy-i>=0) {
				if(d[cx+cy-i][i]==0)cnt++;i++;
			}a=(cnt==(cx+cy+1));
		}
		else if(cx+cy<7) {
			cnt = 0;int i = 7;
			while(cy-(7-cx)+i<8) {
				if(d[cx+cy-1-i][cy-(7-cx)+i]==0)cnt++;i--;
			}a=(cnt==(cx+cy+1));
		}
		return a;
	}
	public static boolean checkDiagSE(int [][] d, int cx, int cy) {
		int cnt = 0;
		boolean a = false;
		if(cx==cy) {
			for(int i=0;i<8;i++) {
				if(d[i][i]==0) cnt++;
			}a=(cnt==8);
			}
		else if(cx>cy) {
			cnt = 0;int i = 0;
			while(cx-cy+i<8) {
				if(d[cx-cy+i][i]==0)cnt++;i++;
			}a= ((8-(cx-cy)) == cnt);
		}
		else if(cx<cy) {
			cnt = 0;
			int i = 0;
		 while	(cy-cx+i<8) {
			if(d[i][cy-cx+i]==0)cnt++;i++;
		}
		 a= ((8-(cy-cx))== cnt);
		}
	return a;
	}
//////////////////////////////////////////////////////////////////////
	public static boolean CheckMove(int [][] d,int x, int y) {
		boolean a = false;
		if((checkRow(d, x)==true)&&(checkCol(d,y))&&(checkDiagSW(d,x,y)==true)&&checkDiagSE(d,x,y)==true) {
			a=true;
		}
		return a;
	}
	
	
public static void main(String[] args) {
	int row = 8, col = 8;
	
	// data 배열 초기화	
	int [][]data = new int[8][8]; 
	for (int i = 0; i <8; i++)
		for (int j = 0; j < 8; j++) {
			data[i][j] = 0;	
		}

	int cnt = 0;
//	SolveQueen(data);
	Stack2 st = new Stack2(100);
	IntStack is = new IntStack(8);
	for (int i = 0; i <8; i++)
		for (int j = 0; j < 8; j++) {
			if (CheckMove(data,i,j)) {
				cnt++;
				data[i][j]=1;
				is.push(j);
				if(j==7) {
//					Point p = new Point(is.pop(),is.pop(),is.pop(),is.pop(),is.pop(),is.pop(),is.pop(),is.pop());
//					st.push(p);
					System.out.println("dump");
					
					st.dump();
//				}
			}
			System.out.println();
			}
			System.out.println();
			printt(data);
		
	
	
		
	}
	System.out.println("dump");
	st.dump();
	System.out.println(cnt);
	}
}

