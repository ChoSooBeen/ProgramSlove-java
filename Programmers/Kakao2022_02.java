package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 큐 같게 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class Kakao2022_02 {
    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0; //queue1의 합
        long sum2 = 0; //queue2의 합
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++) {
            q1.offer((long)queue1[i]);
            sum1 += queue1[i];
            q2.offer((long)queue2[i]);
            sum2 += queue2[i];
        }

        if((sum1 + sum2) % 2 != 0) { //모든 원소의 합이 홀수일 경우
            return -1;
        }

        /**
         * queue1.length == queue2.length이므로
         * 두 큐를 모두 한번씩 순회한 횟수 = limit
         */
        int limit = queue1.length * 4;

        while(sum1 != sum2) {
            //둘 중 큐가 비거나 전부 순회했을 경우
            if(q1.isEmpty() || q2.isEmpty() || answer > limit) {
                break;
            }
            if(sum1 > sum2) {
                long n = q1.poll();
                sum1 -= n;
                sum2 += n;
                q2.offer(n);
                answer++;
            }
            else if(sum1 < sum2) {
                long n = q2.poll();
                sum1 += n;
                sum2 -= n;
                q1.offer(n);
                answer++;
            }
        }

        if(sum1 != sum2) {
            return -1;
        }
        return answer;
    }
}
