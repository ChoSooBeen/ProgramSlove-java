package Programmers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 개인정보 수집 유효 기간
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */
public class Privacy {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    /**
     * 파기해야할 개인정보 번호 구하기
     * @param today 오늘 날짜
     * @param terms 유효기간의 종류 및 달수 (type month) 형식의 문자열 배열
     * @param privacies 개인정보 수집 날짜 (date type) 형식의 문자열 배열
     * @return 파기해야할 개인정보 번호 배열(오름차순 정렬)
     */
    public static int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] tmp = terms[i].split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        int todayTotal = duration(today);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            int expTotal = duration(tmp[0]);
            int exp = map.get(tmp[1]) * 28;
            if(todayTotal >= expTotal + exp) {
                sb.append(i+1);
                sb.append(" ");
            }
        }
        String[] tmp = sb.toString().split(" ");
        int[] answer = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            answer[i] = Integer.parseInt(tmp[i]);
        }
        return answer;
    }

    /**
     * 한달이 28일이라고 가정한 일수 구하기
     * @param date YYYY.MM.DD 형식의 문자열
     * @return 총 일수
     */
    public static int duration(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));

        return (year * 12 * 28) + (month * 28) + day;
    }
}