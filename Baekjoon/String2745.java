package Baekjoon;

import java.util.Scanner;

public class String2745 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String n = input[0];
        int b = Integer.parseInt(input[1]);
        int length = n.length() - 1;

        int answer = 0;
        for(int i = 0; i <= length; i++) {
            char c = n.charAt(i);
            if(c >= '0' && c <= '9') {
                answer += (Math.pow(b, length-i) * (c - '0'));
            }
            else {
                answer += (Math.pow(b, length-i) * (c - 'A' + 10));
            }
        }
        System.out.println(answer);
    }
}
