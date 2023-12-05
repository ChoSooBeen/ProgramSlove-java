package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy1041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dice = new int[6];
        for(int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(minSum(dice, n));
    }

    /**
     * 보여지는 주사위 숫자 합의 최소
     * @param dice 주사위에 적혀있는 숫자 배열
     * @param n 한 변에 놓일 주사위의 개수
     * @return 최솟값
     */
    public static long minSum(int[] dice, int n) {
        if(n == 1) { //주사위 1개만 존재할 경우 예외처리
            Arrays.sort(dice);
            int sum = 0;
            for(int i = 0; i < 5; i++) {
                sum += dice[i];
            }
            return sum;
        }

        long one =  5L * (n-2) * (n-2) + 4L * (n-2); // 1개의 면이 노출되는 주사위 수
        long two = 8L * (n-2) + 4L; // 2개의 면이 노출되는 주사위 수
        long three = 4L; // 3개의 면이 노출되는 주사위 수

        int[] minDice = new int[3];
        for(int i = 0; i < 3; i++) {
            minDice[i] = Math.min(dice[i], dice[5-i]);
        }
        Arrays.sort(minDice);

        long answer = 0;
        answer += three * (minDice[0] + minDice[1] + minDice[2]);
        answer += two * (minDice[0] + minDice[1]);
        answer += one * minDice[0];

        return answer;
    }
}
