package QueenPra;

public class Queen {
    static boolean[] flag_a = new boolean[8]; //각 행에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15]; // / 대각선 방향으로 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15]; // \ 대각선 방향으로 퀸을 배치했는지 체크
    static int[] pos = new int[8]; //각 열의 퀸의 위치


    //각 열의 퀸의 위치를 출력
    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.print(pos[i]+" ");
        }
        System.out.println();
    }

    //i열에 퀸을 배치
static void set(int i) {

 for (int j = 0; j < 8; j++) {
            // / 방향 대각선을 체크하는 배열의 인덱스는 i + j
            // \ 방향 대각선을 체크하는 배열의 인덱스는 i - j + 7
            if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) { //j 행에 배치된 퀸이 없다면,
                pos[i] = j; //퀸을 j행에 배치
                if (i == 7) {  //모든 열에 배치 완료
                    print();
                    
                } else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7]= true;
                    set(i + 1); //다음 열에 퀸을 배치
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7]= false;
                }
            }

        }
        

}

    public static void main(String[] args) {

        set(0);
    }
}