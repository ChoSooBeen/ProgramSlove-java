package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programmers - 소수 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12977
 */
public class Prime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int[] nums = new int[input.length];
        for(int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        System.out.println(countPrime(nums));
    }


    /**
     * 배열의 원소 3개의 합이 소수인 경우의 수 구하기
     * @param nums 숫자 배열
     * @return 소수의 개수
     */
    public static int countPrime(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer += 1;
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 소수 판별
     * @param n 판별할 숫자
     * @return True(소수) / False(소수가 아닐 경우)
     */
    public static boolean isPrime(int n) {
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
