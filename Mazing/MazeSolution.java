package Mazing;




//Maze 초기위치 : 1,1
public class MazeSolution {
	

	
	
static void Sol(int[][] in,int sx, int sy, int dx, int dy) {
   // maze, mark : in보다 1칸씩 많은 배열
   int[][] maze = new int[14][17]; //
   int[][] mark = new int[14][17]; // 
   
   // (1) 가장자리 1로 채움. (2) mark x와 같게,  
   for (int i = 0; i < 14; i++) {
      for (int j = 0; j < 17; j++) {
         if ((i == 0) || (j == 0) || (i == 13) || (j == 16)) {
            maze[i][j] = 1;
            mark[i][j] = 1;
         }
         else {
            maze[i][j] = in[i-1][j-1];
            mark[i][j] = 0;
         }
      }
   }

// 스택, move 생성
MazeStack st = new MazeStack(100);
int[][] move = {
      {1,0}, // E
      {1,1}, // SE
      {0,1}, // S
      {-1,1}, // SW
      {-1,0}, // W
      {-1,-1}, // NW
      {0,-1}, // N
      {1,-1},   // NE
};

 
// 초기 위치 설정한 뒤 스택에 푸시
int px , py, pdir,nextX, nextY;boolean chk = false;
MazeP p = new MazeP(sx,sy,0);
st.push(p); mark[sx][sx] = 1; // 첫 위치를 스택에 푸시하고 마크에 저장

while(!st.isEmpty() && !chk) { // 경로가 없거나 찾을 때까지
   p = st.pop();
   px = p.getX(); py = p.getY(); pdir = p.getDir();   
   while(pdir < 8 && !chk) { // 8방향 다 탐색하거나 경로를 찾을 때까지
      nextX = px + move[pdir][0];
      nextY = py + move[pdir][1];
      if(maze[nextY][nextX] == 0 && mark[nextY][nextX] != 1) { // 다음 위치가 0이거나 왔던길이 아니면
         mark[nextY][nextX] = 1; // 다음 위치 발견하면 mark에 저장
         p = new MazeP(px,py,pdir);
         st.push(p);
         px = nextX; py = nextY; pdir = 0;
      } else {
         pdir++;
      }
      if(px == dx && py == dy){  // 출구에 도착하면
         p = new MazeP(px,py,pdir);
         st.push(p);
         chk = true;
      }
   }
}

if(chk){
   st.dump();
   System.out.println();
} else {
   System.out.println("경로를 찾지 못했습니다.");
}

for (int i = 0; i < 14; i++) {
   for (int j = 0; j < 17; j++) {
      if((i == 0) || (j == 0) || (i == 13) || (j == 16)) {
         System.out.print(" 1");
      } else if (mark[i][j] == 1) {
         System.out.print(" x");
      } else {
         System.out.print(" " + maze[i][j]);
      }
   }
   System.out.println();
}
}

public static void main(String[] args) {
   int[][] in = {
         { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
         { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
         { 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
         { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
         { 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
         { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
         { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
         { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
         { 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
         { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
         { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
         { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
   Sol(in,1,1,15,12);
}

}