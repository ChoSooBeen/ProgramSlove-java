package Programmers;

import java.util.Arrays;

/**
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class Exam {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers)));
    }
    public static int[] solution(int[] answers) {
        int[] score = new int[3];
        int[][] types = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };
        int max = 0;
        for(int i = 0; i < 3; i++) {
            score[i] = getScore(answers, types[i]);
            max = Math.max(max, score[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            if(max == score[i]) {
                sb.append(i+1);
            }
        }
        String[] tmp = sb.toString().split("");
        int[] answer = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            answer[i] = Integer.parseInt(tmp[i]);
        }
        return answer;
    }

    /**
     * 맞힌 점수 계산하기
     * @param answers 정답 배열
     * @param type 찍는 배열
     * @return 점수
     */
    public static int getScore(int[] answers, int[] type) {
        int answer = 0;
        int length = type.length;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == type[i%length]){
                answer++;
            }
        }
        return answer;
    }
}
