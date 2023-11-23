package Programmers;

import java.util.Arrays;

/**
 * 거리두기 확인하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302#fn1
 */
public class Kakao2021_02 {
    public static void main(String[] args) {
        String[][] places = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        System.out.println(Arrays.toString(solution(places)));
    }
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++) {
            answer[i] = isOkay(places[i]);
        }
        return answer;
    }

    /**
     * 현재 대기실이 거리두기가 잘 지켜지는 확인
     * @param ready 대기실 상태 배열
     * @return 잘 지켜지면 1, 안지켜지면 0
     */
    public static int isOkay(String[] ready) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(ready[i].charAt(j) == 'P' && sides(ready, i, j)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    /**
     * 현재 위치에서 거리가 2 이내인 위치 확인
     * @param ready 대기실 상태
     * @param x 현재 위치의 행 번호
     * @param y 현재 위치의 열 번호
     * @return 현재 위치에서 올바르게 거리두기 되어 있으면 false, 아니면 true
     */
    public static boolean sides(String[] ready, int x, int y) {
        //우, 하, 좌, 상
        int[] dx = {0,1,0,-1,0,2,0,-2};
        int[] dy = {1,0,-1,0,2,0,-2,0};
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && ready[nx].charAt(ny) == 'P') {
                if(i < 4) {
                    return true;
                }
                if(ready[x+dx[i-4]].charAt(y+dy[i-4]) != 'X') {
                    return true;
                }
            }
        }

        //대각선
        int[] tx = {-1, -1, 1, 1};
        int[] ty = {-1, 1, -1, 1};
        for(int i = 0; i < 4; i++) {
            int nx = x + tx[i];
            int ny = y + ty[i];
            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && ready[nx].charAt(ny) == 'P') {
                if(ready[nx].charAt(y) != 'X' || ready[x].charAt(ny) != 'X') {
                    return true;
                }
            }
        }
        return false;
    }
}
