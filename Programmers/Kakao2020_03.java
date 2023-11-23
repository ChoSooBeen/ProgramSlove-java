package Programmers;

import java.util.*;

/**
 * 보석 쇼핑
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 */
public class Kakao2020_03 {
    public static void main(String[] args) {
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(Arrays.toString(solution(gems)));
    }
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int count = new HashSet<>(Arrays.asList(gems)).size(); //보석 종류의 개수

        HashMap<String, Integer> map = new HashMap<>();

        int length = gems.length + 1; //선택된 길이
        int start = 0; //시작점
        for(int i = 0; i < gems.length; i++) { //i = 끝점
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            //맨 앞에 있는 보석이 뒤에도 존재하면 시작점 증가
            while(map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            //모든 보석이 들어있으면서 길이 짧을 경우 업데이트
            if(map.size() == count && length > (i - start)) {
                length = i - start;
                answer[0] = start + 1;
                answer[1] = i + 1;
            }
        }
        return answer;
    }
}
