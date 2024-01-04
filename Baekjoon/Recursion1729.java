package Baekjoon;

import java.util.Scanner;

public class Recursion1729 {
    public static StringBuilder sb;
    public static int count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        sb = new StringBuilder();
        count = 0;

        hanoi(n, 1, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    /**
     * 하노이 탑
     * @param n 이동해야할 원판의 개수
     * @param start 현재 있는 번호
     * @param end 이동해야할 번호
     */
    public static void hanoi(int n, int start, int end) {
        count++;
        if(n > 1) {
            hanoi(n-1, start, 6 - start - end);
        }
        sb.append(start + " " + end + "\n");
        if(n > 1) {
            hanoi(n-1, 6 - start - end, end);
        }
    }
}
