package Programmers;

import java.util.Arrays;

public class Kakao2022_03 {
    public static void main(String[] args) {
        int alp = 10;
        int cop = 10;
        int[][] probleams = {{10,15,2,1,2},{20,20,3,3,4}};
        System.out.println(solution(alp, cop, probleams));
    }

    /**
     * DP
     * @param alp 알고력
     * @param cop 코딩력
     * @param problems 문제 배열 [alp_req, cop_req, alp_rwd, cop_rwd, cost]
     * @return 최소시간
     */
    public static int solution(int alp, int cop, int[][] problems) {
        int max_alp = 0; //달성해야할 알고력
        int max_cop = 0; //달성해야할 코딩력
        for(int[] problem : problems) {
            max_alp = Math.max(max_alp, problem[0]);
            max_cop = Math.max(max_cop, problem[1]);
        }

        int[][] dp = new int[max_alp+1][max_cop+1]; //dp[i][j] = 알고력 i, 코딩력 j에 달성하기 위한 최소시간
        for(int i = 0; i <= max_alp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        alp = Math.min(alp, max_alp);
        cop = Math.min(cop, max_cop);
        dp[alp][cop] = 0;

        for(int i = alp; i <= max_alp; i++) {
            for(int j = cop; j <= max_cop; j++) {
                if(i < max_alp) { //알고리즘 학습으로 알고력 올리기
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                }
                if(j < max_cop) { //코딩 학습으로 코딩력 올리기
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                }
                for(int[] problem : problems){ //문제풀이로 알고력과 코딩력 올리기
                    if(i >= problem[0] && j >= problem[1]) {
                        int a = Math.min(i + problem[2], max_alp);
                        int c = Math.min(j + problem[3], max_cop);
                        dp[a][c] = Math.min(dp[a][c], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        return dp[max_alp][max_cop];
    }
}
