package Programmers;

import java.util.HashMap;

/**
 * 외계어 사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/120869
 */
public class AlienDict {
    public static void main(String[] args) {
        String[] spell = {"s", "o", "m", "d"};
        String[] dic = {"moos", "dzx", "smm", "sunmmo", "som"};
        System.out.println(solution(spell, dic));
    }

    /**
     * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2
     * @param spell 알파벳이 담긴 배열
     * @param dic 외계어 사전
     * @return 존재 여부
     */
    public static int solution(String[] spell, String[] dic) {
        int answer = 2;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < spell.length; i++) {
            map.put(spell[i], i);
        }

        for(int i = 0; i < dic.length; i++) {
            if(dic[i].length() != spell.length) { //가지고 있는 알파벳의 개수와 길이가 다르면 넘어간다.
                continue;
            }
            boolean flag = true;
            boolean[] visited = new boolean[spell.length]; //알파벳 사용 여부
            for(String s : dic[i].split("")) {
                if(!map.containsKey(s) || visited[map.get(s)]) {
                    flag = false;
                    break;
                }
                else {
                    visited[map.get(s)] = true;
                }
            }
            if(flag) {
                return 1;
            }
        }
        return answer;
    }
}
