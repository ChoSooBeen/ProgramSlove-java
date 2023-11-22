package Programmers;

import java.util.HashMap;
import java.util.Stack;

/**
 * 수식 최대화
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 */
public class Kakao2020_02 {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }
    static StringBuilder order; //모든 생성된 수열 저장
    public static long solution(String expression) {
        order = new StringBuilder();

        StringBuilder exp = new StringBuilder();
        HashMap<String, Integer> operation = new HashMap<>();
        for(int i = 0; i < expression.length(); i++) {
            char n = expression.charAt(i);
            if(n == '+' || n == '*' || n == '-') {
                exp.append(" ");
                exp.append(expression.charAt(i));
                exp.append(" ");
                operation.put(Character.toString(n), 0);
                continue;
            }
            exp.append(expression.charAt(i));
        }
        expression = exp.toString(); //표현식에 공백 추가하기

        int depth = operation.size(); //연산자 종류의 수
        boolean[] visited = new boolean[depth];
        String[] keys = operation.keySet().toArray(new String[0]);
        perm(keys, depth, 0, visited, "");

        long answer = 0;
        String[] orders = order.toString().split("\n");
        for(String s : orders) {
            String[] t = s.split(" ");
            for(int i = 0; i < t.length; i++) {
                operation.put(t[i], depth-i);
            }
            answer = Math.max(Math.abs(calculate(convertToPostfix(expression, operation))), answer);
        }
        return answer;
    }

    /**
     * 연산자 우선순위 수열 생성
     * @param operation 연산자 배열
     * @param depth 연산자 종류 개수
     * @param count 현재까지 탐색한 수
     * @param visited 방문 여부
     * @param result 생성된 수열
     */
    public static void perm(String[] operation, int depth, int count, boolean[] visited, String result) {
        if(count == depth) {
            order.append(result).append("\n");
            return;
        }
        for(int i = 0; i < depth; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm(operation, depth, count+1, visited, result + operation[i] + " ");
                visited[i] = false;
            }
        }
    }

    /**
     * 중위표기식을 후위표기식으로 변경
     * @param expression 중위표기식
     * @param op 연산자 우선순위
     * @return 후위표기식
     */
    public static String convertToPostfix(String expression, HashMap<String, Integer> op) {
        String answer = "";
        String[] exp = expression.split(" ");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < exp.length; i++) {
            if(i % 2 != 0) {
                while((!stack.isEmpty()) && (op.get(exp[i]) <= op.get(stack.peek()))) {
                    answer += (stack.pop() + " ");
                }
                stack.push(exp[i]);
            }
            else {
                answer += (exp[i] + " ");
            }
        }
        while(!stack.isEmpty()) {
            answer += (stack.pop() + " ");
        }
        return answer;
    }

    /**
     * 후위표기식 계산
     * @param expression 후위표기식
     * @return 계산 결과
     */
    public static long calculate(String expression) {
        String[] exp = expression.split(" ");
        Stack<Long> stack = new Stack<>();
        for(String s : exp) {
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if(s.equals("-")) {
                long t = stack.pop();
                stack.push(stack.pop() - t);
            }
            else if(s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else {
                stack.push(Long.parseLong(s));
            }
        }
        return stack.peek();
    }
}
