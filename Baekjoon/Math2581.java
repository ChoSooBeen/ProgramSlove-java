package Baekjoon;

import java.io.*;

public class Math2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int total = 0;
        int min = Integer.MAX_VALUE;

        for(int number = m; number <= n; number++) {
            if(isPrime(number)) {
                total += number;
                min = Math.min(min, number);
            }
        }

        if(total == 0) {
            bw.write("-1"); //String형 출력 가능!
        }
        else {
            bw.write(total + "\n" + min);
        }

        bw.flush();
        bw.close();
    }

    /**
     * 소수 판별 함수
     * @param number 현재 판별할 자연수
     * @return 소수일 경우 true, 아니면 false
     */
    public static boolean isPrime(int number) {
        if(number == 1) { //1 예외처리 - 소수 아님
            return false;
        }
        if (number == 2) { //2 예외처리 - 소수
            return true;
        }

        //3이상의 수부터 확인
        for(int i = 2; i <= Math.sqrt(number)+1; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
