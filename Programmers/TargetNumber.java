package Programmers;

/**
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }
    public static int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    /**
     * DFS
     * @param numbers 숫자 배열
     * @param target 타겟 숫자
     * @param idx 현재 인덱스
     * @param current 현재 계산 결과
     * @return 타겟 넘버를 만들면 1 아니면 0
     */
    public static int dfs(int[] numbers, int target, int idx, int current) {
        if(idx == numbers.length) { //배열 전체 순회 완료되었을 시
            if(target == current) { //타겟 숫자를 만들었을 경우
                return 1;
            }
            return 0; //못 만들었을 경우
        }
        int answer = dfs(numbers, target, idx+1, current+numbers[idx]); // + 경우
        answer += dfs(numbers, target, idx+1, current-numbers[idx]); // - 경우
        return answer;
    }
}
