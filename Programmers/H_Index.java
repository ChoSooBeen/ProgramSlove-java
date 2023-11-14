package Programmers;

import java.util.Arrays;

/**
 * H-Index
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 4};
        System.out.println(solution(citations));
    }
    public static int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        Arrays.sort(citations); //오름차순 정렬
        for(int i = length-1; i >= 0; i--) { //큰 수부터 확인
            if(citations[i] <= length - i) { //인용된 논문의 수가 인용 횟수보다 클 경우 h-index
                answer = Math.max(citations[i], length - i - 1);
                break;
            }
        }

        // 인용 횟수가 전부 0이 아닌데 answer가 0일 경우 예외처리
        if(citations[length-1] != 0 && answer == 0) {
            answer = length;
        }
        return answer;
    }
}
