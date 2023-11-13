package Programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Number2 {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        boolean flag = true; //numbers에 들어있는 모든 수가 0일 경우 true
        for(int i = 0; i < nums.length; i++) { //사전순으로 처리하기 위한 String형 변환
            nums[i] = Integer.toString(numbers[i]);
            if(numbers[i] != 0) {
                flag = false;
            }
        }
        if(flag) { //정렬해도 모두 0이므로 예외처리
            return "0";
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : nums) {
            sb.append(s);
        }
        return sb.toString();
    }
}
