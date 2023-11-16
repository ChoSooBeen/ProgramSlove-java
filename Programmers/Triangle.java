package Programmers;

/**
 * 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Triangle {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(DynamicProgramming(triangle));
        System.out.println(DP(triangle));
    }

    /**
     * DP를 이용한 풀이 - 하향식
     * @param triangle 삼각형 정수 저장 배열
     * @return 최댓값
     */
    public static int DynamicProgramming(int[][] triangle) {
        int answer = 0;
        int length = triangle.length;
        int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < length; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0]; //가장 왼쪽 값
            for(int j = 1; j < i; j++) //중간값
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; //가장 오른쪽 값
        }
        for(int i = 0; i < length; i++) {
            answer = Math.max(answer, dp[length-1][i]);
        }
        return answer;
    }

    /**
     * triangle 배열을 사용한 DP
     */
    public static int DP(int[][] triangle) {
        int answer = 0;
        int length = triangle.length;
        for(int i = 1; i < length; i++) {
            triangle[i][0] += triangle[i-1][0];
            for(int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
            triangle[i][i] += triangle[i-1][i-1];
        }
        for(int i = 0; i < length; i++) {
            answer = Math.max(answer, triangle[length-1][i]);
        }
        return answer;
    }
}
