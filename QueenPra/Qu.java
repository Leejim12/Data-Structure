package QueenPra;

//import java.util.Stack;


//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp

//N Queen problem / backtracking
//class Point {
// int x, y;
//
// public Point(int x, int y) {
//    this.x = x;
//    this.y = y;
// }
//
//public int getX() {
//	return x;
//}
//
//public void setX(int x) {
//	this.x = x;
//}
//
//public int getY() {
//	return y;
//}
//
//public void setY(int y) {
//	this.y = y;
//}
//}

class Qun {
	
	
 public static void SolveQueen(int[][] d) {
    int count = 0;
    int ix = 0, iy = 0;
    Stack2 st = new Stack2(100);
    System.out.println(ix + " " + iy);
    Point O = new Point(0,0);
    d[ix][iy]=1;count++;st.push(O);
    int cx = 1;
    int cy = 0;
    while(count<8) { // 다 채울때까지 
        	while(cx<8) { 
        		cy=0;
        		while(cy<8) {
        			if(NextMove(d, cx, cy)<d.length)
        			cy = NextMove(d, cx, cy);
        			if (cy != d.length) {
        				d[cx][cy]=1;
        				count++;
        				Point px = new Point(cx, cy);
        				st.push(px);
        				break;
        			}
        			else if (cy == d.length) {
        				O = st.pop();count--;cx=O.getX();cy=O.getY();d[cx][cy]=0;cy++;
        			}
        		}
        		cx++;
        	}
    }
 }
 
 

 public static boolean checkRow(int[][] d, int crow) {
    for (int i = 0; i < d[0].length; i++)
       if (d[crow][i] == 1)
          return false;
    return true;

 }

 public static boolean checkCol(int[][] d, int ccol) {
    for (int i = 0; i < d.length; i++)
       if (d[i][ccol] == 1)
          return false;
    return true;
 }

 public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++,
    for (int i = cx, j = cy; 0 <= i && i < 8 && 0 <= j && j <= 7; i++, j--)
       if (d[i][j] == 1)
          return false;
    for (int i = cx, j = cy; 0 <= i && i < 8 && 0 <= j && j <= 7; i--, j++)
       if (d[i][j] == 1)
          return false;
    return true;
 }

 public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++,
    // y++
    // or
    // x--,
    // y--

    for (int i = cx, j = cy; 0 <= i && i < 8 && 0 <= j && j <= 7; i++, j++)
       if (d[i][j] == 1)
          return false;
    for (int i = cx, j = cy; 0 <= i && i < 8 && 0 <= j && j <= 7; i--, j--)
       if (d[i][j] == 1)
          return false;

    return true;
 }

 public static boolean CheckMove(int[][] d, int x, int y) {// (x,y)로 이동
    // 가능한지를
    // check
    if (checkRow(d, x) && checkCol(d, y) && checkDiagSE(d,x, y)
          && checkDiagSW(d, x, y))
       return true;
    return false;

 }

 public static int NextMove(int[][] d, int row, int col) {
    // 특정 row에 대하여 col을 이동하여 이동할 체크하고 위치 col을 리턴한다
    while (col < d.length) {
       if (CheckMove(d, row, col))
        return col;
       	col++;
    }
    return d.length;// 
 }

}

public class Qu{
 public static void main(String[] args) {
    int row = 8, col = 8;
    int[][] data = new int[row][col];

    for (int i = 0; i < data.length; i++)
       for (int j = 0; j < data[0].length; j++)
          data[i][j] = 0;

    Qun.SolveQueen(data);

    for (int i = 0; i < data.length; i++) {
       for (int j = 0; j < data[0].length; j++) {
          System.out.print(" " + data[i][j]);
       }
       System.out.println();
    }
 }

}

