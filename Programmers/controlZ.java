package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 컨트롤 제트
 * https://school.programmers.co.kr/learn/courses/30/lessons/120853
 */
public class controlZ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(solution(s));
    }

    /**
     * 문자열에 있는 숫자를 차례대로 더한다. 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다
     * @param s 숫자 또는 Z 가 공백으로 구분되는 문자열
     * @return 숫자 합
     */
    public static int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        String[] input = s.split(" ");
        for(int i = 0; i < input.length; i++) {
            if(input[i].compareTo("Z") == 0) {
                if(!stack.isEmpty()) {
                    int n = stack.pop();
                    answer -= n;
                }
            }
            else {
                int n = Integer.parseInt(input[i]);
                answer += n;
                stack.push(n);
            }
        }
        return answer;
    }
}
