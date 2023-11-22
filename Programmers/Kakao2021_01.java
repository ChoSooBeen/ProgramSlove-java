package Programmers;

import java.util.HashMap;

/**
 * 숫자 문자열과 영단어
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */
public class Kakao2021_01 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
        System.out.println(useReplace(s));
    }

    /**
     * 문자열을 하나씩 탐색하며 확인하는 코드
     * 시간적으로 오래 걸린다.
     */
    public static int solution(String s) {
        int answer = 0;
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        int idx = 0;
        while(idx < s.length()) {
            int n = s.charAt(idx) - '0';
            if(n >= 0 && n < 10) {
                answer = answer * 10 + n;
                idx++;
            }
            else {
                String tmp = Character.toString(s.charAt(idx));
                for(int i = idx+1; i < s.length(); i++) {
                    tmp += Character.toString(s.charAt(i));
                    if(map.containsKey(tmp)) {
                        answer = answer * 10 + map.get(tmp);
                        idx = i+1;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 정규표현식을 사용한 repalceAll() 메소드 사용
     * 더 빠르게 처리 가능
     */
    public static int useReplace(String s) {
        String[] alp = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
        for(int i = 0; i < alp.length; i++) {
            s = s.replaceAll(alp[i], num[i]);
        }
        return Integer.parseInt(s);
    }
}
