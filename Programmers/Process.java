package Programmers;

import java.util.*;

/**
 * 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Process {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>(); //실행 대기 큐
        int[] priority = new int[10]; //우선순위 별 프로세스 개수

        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
            priority[priorities[i]] += 1;
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll(); //0: 프로세스 번호, 1: 우선순위
            boolean flag = true; //실행 여부
            for(int i = 9; i > current[1]; i--) {
                if(priority[i] > 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                priority[current[1]] -= 1;
                answer++;
                if(current[0] == location)
                    break;
            }
            else {
                queue.offer(current);
            }
        }
        return answer;
    }
}
