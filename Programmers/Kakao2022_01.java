package Programmers;

import java.util.HashMap;

/**
 * 성격 유형 검사하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
public class Kakao2022_01 {
    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        System.out.println(solution(survey, choices));
    }

    /**
     * 성격 유형 검사 결과
     * @param survey 지표
     * @param choices 선택지
     * @return 성격 유형 반환
     */
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for(int i = 0; i < types.length; i++) {
            map.put(types[i], 0);
        }
        for(int i = 0; i < survey.length; i++) {
            String[] t = survey[i].split("");
            if(choices[i] < 4) {
                map.put(t[0], map.get(t[0]) + 4 - choices[i]);
            }
            else if(choices[i] > 4) {
                map.put(t[1], map.get(t[1]) + choices[i] - 4);
            }
        }
        for(int i = 0; i < types.length-1; i+=2) {
            int a = map.get(types[i]);
            int b = map.get(types[i+1]);
            if(a >= b) {
                answer += types[i];
            }
            else {
                answer += types[i+1];
            }
        }
        return answer;
    }
}
