package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 같은 숫자는 싫어
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
public class Number {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(solution(arr)));
    }

    /**
     * Queue - FIFO 이용
     * @param arr 0~9 숫자 배열
     * @return 연속된 숫자가 제거된 정수형 배열
     */
    public static int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] != arr[i]) {
                queue.offer(arr[i]);
            }
        }
        int[] answer = new int[queue.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}
