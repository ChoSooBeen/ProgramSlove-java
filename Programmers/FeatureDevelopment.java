package Programmers;

import java.util.Arrays;

/**
 * 기능 개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class FeatureDevelopment {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    /**
     * 완료일 계산하여 푸는 방법
     * @param progresses 작업 진도 배열
     * @param speeds 작업 속도 배열
     * @return 배포 개수 배열
     */
    public static int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        int[] days = new int[length];
        for(int i = 0; i < length; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0)
                days[i] += 1;
        }
        StringBuilder sb = new StringBuilder();
        int current = days[0];
        int count = 1;
        for(int i = 1; i < length; i++) {
            if(current >= days[i]) {
                count++;
            }
            else {
                sb.append(count).append(" ");
                current = days[i];
                count = 1;
            }
        }
        sb.append(count);
        String[] tmp = sb.toString().split(" ");
        int[] answer = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            answer[i] = Integer.parseInt(tmp[i]);
        }
        return answer;
    }
}
