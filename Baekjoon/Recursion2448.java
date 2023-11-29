package Baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Recursion2448 {
    public static char[][] star; // 별을 찍을 위치를 나타내는 2차원 배열
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(scanner.nextLine());
        star = new char[n][2*n-1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(star[i], ' ');
        }
        drawStar(n, 0, n-1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n-1; j++) {
                bw.write(star[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    /**
     * 별찍기
     * @param n 찍어야할 삼각형 개수
     * @param x 삼각형 가장 위의 x좌표
     * @param y 삼각형 가장 위의 y좌표
     */
    public static void drawStar(int n, int x, int y) {
        if(n == 3) {
            star[x][y] = '*';
            star[x+1][y-1] = star[x+1][y+1] = '*';
            star[x+2][y-2] = star[x+2][y-1] = star[x+2][y] = star[x+2][y+1] = star[x+2][y+2] = '*';
            return;
        }

        drawStar(n/2, x, y);
        drawStar(n/2, x + n/2, y - n/2);
        drawStar(n/2, x + n/2, y + n/2);
    }
}
